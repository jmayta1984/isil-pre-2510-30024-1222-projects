package pe.isil.notifications

import android.Manifest
import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat


object NotificationHelper {
    private const val CHANNEL_ID = "pe.isil.notifications.channel"
    private const val CHANNEL_NAME = "Notifications Channel"
    private const val CHANNEL_DESCRIPTION = "Channel for Notifications"

    fun createNotificationChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = CHANNEL_DESCRIPTION
            }
            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    fun sendNotification(context: Context) {

        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
           return
        }
       val builder = NotificationCompat.Builder(context, CHANNEL_ID)
           .setSmallIcon(android.R.drawable.ic_notification_overlay)
           .setContentTitle("Notification")
           .setContentText("Basic notification")
           .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        with (NotificationManagerCompat.from(context)) {

            notify(1, builder.build())
        }
    }
}