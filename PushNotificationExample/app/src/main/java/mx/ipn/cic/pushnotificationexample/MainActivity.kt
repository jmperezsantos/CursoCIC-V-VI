package mx.ipn.cic.pushnotificationexample

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val token = task.result
                Log.i("MPS", "addOnCompleteListener: $token")

                // TODO Enviarlo a un WS
                // TODO Guardarlo para identificicar el dispositivo/usuario
                // TODO guardarlo en una BD Local
            } else {
                Log.e("MPS", "No se pudo obtener un token!!")
            }

        }

        createNotificationChannel()
    }

    private fun createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val name = getString(R.string.channel_name)
            val id = getString(R.string.default_notification_channel_id)
            val description = getString(R.string.channel_description)

            val importance = NotificationManager.IMPORTANCE_DEFAULT

            //Se crea el canal de mensajería
            val channel = NotificationChannel(id, name, importance)
            channel.description = description

            //Se obtiene una referencia del notification manager
            val notificationManager =
                this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            //Se le indica al notificacion manager que cree el canal de mensajería.
            notificationManager.createNotificationChannel(channel)
        }

    }
}