package com.matveichuk.smartkids.worker

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.matveichuk.smartkids.R
import com.matveichuk.smartkids.db.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject


class PeriodicWorker(appContext: Context, params: WorkerParameters) : Worker(appContext, params),
    KoinComponent {

    val scoreDao: ScoreDao by inject()

    override fun doWork(): Result {
        val num: Flow<List<Score>> = scoreDao.getScore()
        GlobalScope.launch(Dispatchers.Main) {
            num.map { it?.toList().size.toString() }
            createNotification("Your score $num")
        }


        return Result.success()
    }

    private fun createNotification(description: String) {

        val notificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel =
                NotificationChannel("101", "channel", NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        val notificationBuilder = NotificationCompat.Builder(applicationContext, "101")
            .setContentText(description)
            .setSmallIcon(R.drawable.ic_star)

        notificationManager.notify(1, notificationBuilder.build())

    }

}