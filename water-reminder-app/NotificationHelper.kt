package com.example.waterreminderapp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat

object NotificationHelper {

    private const val CHANNEL_ID = "water_reminder_channel"

    fun showNotification(context: Context) {

        val manager =
            context.getSystemService(Context.NOTIFICATION_SERVICE)
                    as NotificationManager

        val channel = NotificationChannel(
            CHANNEL_ID,
            "Water Reminder",
            NotificationManager.IMPORTANCE_DEFAULT
        )

        manager.createNotificationChannel(channel)

        val notification =
            NotificationCompat.Builder(context, CHANNEL_ID)
                .setContentTitle("Recordatorio")
                .setContentText("¡Es hora de beber agua!")
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .build()

        manager.notify(1, notification)
    }
}