package com.iamhuitron.rutinaoptima;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class RoutineWidgetProvider extends AppWidgetProvider {

    public static final String ACTION_REFRESH_WIDGET = "com.iamhuitron.rutinaoptima.ACTION_REFRESH_WIDGET";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int id : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, id);
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if (intent != null && ACTION_REFRESH_WIDGET.equals(intent.getAction())) {
            updateAllWidgets(context);
        }
    }

    public static void updateAllWidgets(Context context) {
        AppWidgetManager manager = AppWidgetManager.getInstance(context);
        ComponentName componentName = new ComponentName(context, RoutineWidgetProvider.class);
        int[] ids = manager.getAppWidgetIds(componentName);
        if (ids != null) {
            for (int id : ids) {
                updateAppWidget(context, manager, id);
            }
        }
    }

    public static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
        RoutineData.ActiveStatus status = RoutineData.getActiveStatus();
        RoutineData.Block current = status.current;
        RoutineData.Block next = status.next;

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_routine);

        views.setTextViewText(R.id.widget_day_badge, "⚡ RUTINA MAESTRA • " + status.dayTitle.toUpperCase());
        views.setTextViewText(R.id.widget_current_label, "AHORA (" + status.progressPercent + "% • faltan " + status.minutesRemaining + "m)");
        views.setTextViewText(R.id.widget_current_time, current.timeRange);
        views.setTextViewText(R.id.widget_current_title, current.icon + " " + current.title);
        views.setTextViewText(R.id.widget_current_desc, current.description);
        views.setProgressBar(R.id.widget_progress, 100, status.progressPercent, false);

        views.setTextViewText(R.id.widget_next_title, "➡️ Siguiente: " + next.icon + " " + next.title);
        views.setTextViewText(R.id.widget_next_time, next.timeRange);

        Intent openAppIntent = new Intent(context, MainActivity.class);
        openAppIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent openAppPending = PendingIntent.getActivity(
                context,
                0,
                openAppIntent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
        );
        views.setOnClickPendingIntent(R.id.widget_active_card, openAppPending);
        views.setOnClickPendingIntent(R.id.widget_next_card, openAppPending);

        Intent refreshIntent = new Intent(context, RoutineWidgetProvider.class);
        refreshIntent.setAction(ACTION_REFRESH_WIDGET);
        PendingIntent refreshPending = PendingIntent.getBroadcast(
                context,
                1,
                refreshIntent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
        );
        views.setOnClickPendingIntent(R.id.widget_refresh_btn, refreshPending);

        appWidgetManager.updateAppWidget(appWidgetId, views);
    }
}
