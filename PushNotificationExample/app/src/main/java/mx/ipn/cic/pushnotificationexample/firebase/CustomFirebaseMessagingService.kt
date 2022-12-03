package mx.ipn.cic.pushnotificationexample.firebase

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import mx.ipn.cic.pushnotificationexample.MainActivity
import mx.ipn.cic.pushnotificationexample.R
import java.util.*

class CustomFirebaseMessagingService : FirebaseMessagingService() {

    //Notifica cuando un nuevo Token llega
    override fun onNewToken(token: String) {
        super.onNewToken(token)

        Log.i("MPS", "onNewToken: $token")

        // TODO Enviarlo a un WS
        // TODO Guardarlo para identificicar el dispositivo/usuario
        // TODO guardarlo en una BD Local

    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        val title = message.notification?.title
        val body = message.notification?.body

        Log.i("MPS", "TITULO: $title")
        Log.i("MPS", "BODY: $body")

        if(message.data != null){

            Log.i("MPS", "idAlgo: ${message.data["idAlgo"]}")
            Log.i("MPS", "extra1: ${message.data["extra1"]}")
            Log.i("MPS", "extra2: ${message.data["extra2"]}")

        }

        launchLocalNotification(message)

    }

    private fun launchLocalNotification(message: RemoteMessage) {

        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_IMMUTABLE
        )

        val channelId = getString(R.string.default_notification_channel_id)
        val notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setContentTitle(message.notification?.title)
            .setSmallIcon(R.drawable.notification)
            .setColor(getColor(R.color.notification_color))
            .setContentText(message.notification?.body)
            .setContentIntent(pendingIntent)

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val notification = notificationBuilder.build()
        val notificationId = Random().nextInt()

        notificationManager.notify(notificationId, notification)

    }

}