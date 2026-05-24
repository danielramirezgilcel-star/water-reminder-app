package com.example.waterreminderapp

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

@Composable
fun ReminderScreen(context: Context) {

    ReminderUI(
        onActivateReminder = {

            val workRequest =
                PeriodicWorkRequestBuilder<WaterReminderWorker>(
                    15,
                    TimeUnit.MINUTES
                ).build()

            WorkManager
                .getInstance(context)
                .enqueue(workRequest)
        }
    )
}