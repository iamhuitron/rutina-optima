package com.iamhuitron.rutinaoptima;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import java.util.Calendar;

public class RoutineNotificationHelper {

    public static final String CHANNEL_ID = "rutina_s23_alerts_v1";
    private static final String PREFS_NAME = "rutina_s23_prefs";
    private static final String KEY_ALARMS_ENABLED = "alarms_enabled";

    public static void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "Alertas de Bloques de Rutina",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel.setDescription("Notificaciones automáticas al iniciar cada bloque de tu rutina diaria (HGH, V-Taper, Trabajo, Uni)");
            channel.enableVibration(true);
            NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            if (manager != null) {
                manager.createNotificationChannel(channel);
            }
        }
    }

    public static boolean areAlarmsEnabled(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return prefs.getBoolean(KEY_ALARMS_ENABLED, true);
    }

    public static void setAlarmsEnabled(Context context, boolean enabled) {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
                .edit()
                .putBoolean(KEY_ALARMS_ENABLED, enabled)
                .apply();
        if (enabled) {
            scheduleAllAlarms(context);
        } else {
            cancelAllAlarms(context);
        }
    }

    public static void showBlockNotification(
            Context context,
            int notificationId,
            String title,
            String timeRange,
            String badge,
            String description
    ) {
        createNotificationChannel(context);

        Intent openIntent = new Intent(context, MainActivity.class);
        openIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingOpen = PendingIntent.getActivity(
                context,
                notificationId,
                openIntent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
        );

        Notification.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder = new Notification.Builder(context, CHANNEL_ID);
        } else {
            builder = new Notification.Builder(context);
        }

        String fullText = description + "\n\n⏱️ Horario: " + timeRange + " • Categoría: " + badge;

        builder.setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle(title + " (" + timeRange + ")")
                .setSubText(badge)
                .setContentText(description)
                .setStyle(new Notification.BigTextStyle().bigText(fullText))
                .setColor(0xFF6366F1)
                .setAutoCancel(true)
                .setContentIntent(pendingOpen);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (manager != null) {
            try {
                manager.notify(notificationId, builder.build());
            } catch (SecurityException ignored) {
            }
        }
    }

    public static void triggerImmediateStatusNotification(Context context) {
        RoutineData.ActiveStatus status = RoutineData.getActiveStatus();
        RoutineData.Block current = status.current;
        RoutineData.Block next = status.next;

        showBlockNotification(
                context,
                9999,
                current.icon + " AHORA: " + current.title,
                current.timeRange,
                status.dayTitle + " • " + current.badge,
                current.description + "\n➡️ Siguiente (" + next.timeRange + "): " + next.icon + " " + next.title
        );
        RoutineWidgetProvider.updateAllWidgets(context);
    }

    public static void scheduleAllAlarms(Context context) {
        createNotificationChannel(context);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        if (alarmManager == null) return;

        Calendar now = Calendar.getInstance();
        for (RoutineData.Block block : RoutineData.getAllBlocks()) {
            long triggerMillis = computeNextTriggerMillis(now, block);
            Intent intent = new Intent(context, RoutineAlarmReceiver.class);
            intent.putExtra("block_id", block.id);
            intent.putExtra("title", block.icon + " " + block.title);
            intent.putExtra("time_range", block.timeRange);
            intent.putExtra("badge", block.dayTitle + " • " + block.badge);
            intent.putExtra("description", block.description);

            PendingIntent pi = PendingIntent.getBroadcast(
                    context,
                    block.id,
                    intent,
                    PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
            );
            scheduleExactOrFallback(alarmManager, triggerMillis, pi);
        }
    }

    public static void cancelAllAlarms(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        if (alarmManager == null) return;

        for (RoutineData.Block block : RoutineData.getAllBlocks()) {
            Intent intent = new Intent(context, RoutineAlarmReceiver.class);
            PendingIntent pi = PendingIntent.getBroadcast(
                    context,
                    block.id,
                    intent,
                    PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
            );
            alarmManager.cancel(pi);
        }
    }

    private static long computeNextTriggerMillis(Calendar now, RoutineData.Block block) {
        Calendar target = (Calendar) now.clone();
        target.set(Calendar.SECOND, 0);
        target.set(Calendar.MILLISECOND, 0);
        target.set(Calendar.HOUR_OF_DAY, block.startHour);
        target.set(Calendar.MINUTE, block.startMin);

        int currentDow = target.get(Calendar.DAY_OF_WEEK);
        int daysDiff = (block.dayOfWeek - currentDow + 7) % 7;
        if (daysDiff == 0 && target.getTimeInMillis() <= now.getTimeInMillis()) {
            daysDiff = 7;
        }
        target.add(Calendar.DAY_OF_YEAR, daysDiff);
        return target.getTimeInMillis();
    }

    private static void scheduleExactOrFallback(AlarmManager alarmManager, long triggerAtMillis, PendingIntent operation) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                if (alarmManager.canScheduleExactAlarms()) {
                    alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, triggerAtMillis, operation);
                } else {
                    alarmManager.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, triggerAtMillis, operation);
                }
            } else {
                alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, triggerAtMillis, operation);
            }
        } catch (SecurityException e) {
            alarmManager.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, triggerAtMillis, operation);
        }
    }
}
