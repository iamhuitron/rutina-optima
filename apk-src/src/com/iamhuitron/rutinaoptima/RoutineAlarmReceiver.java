package com.iamhuitron.rutinaoptima;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class RoutineAlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int blockId = intent.getIntExtra("block_id", 1001);
        String title = intent.getStringExtra("title");
        if (title == null) title = "⚡ Nuevo Bloque de Rutina";
        String timeRange = intent.getStringExtra("time_range");
        if (timeRange == null) timeRange = "";
        String badge = intent.getStringExtra("badge");
        if (badge == null) badge = "Rutina Maestra";
        String description = intent.getStringExtra("description");
        if (description == null) description = "Revisa tu siguiente actividad.";

        if (RoutineNotificationHelper.areAlarmsEnabled(context)) {
            RoutineNotificationHelper.showBlockNotification(
                    context,
                    blockId,
                    title,
                    timeRange,
                    badge,
                    description
            );
            RoutineNotificationHelper.scheduleAllAlarms(context);
        }
        RoutineWidgetProvider.updateAllWidgets(context);
    }
}
