package mx.ipn.cic.dependencyinjectionexample

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CustomApplication : Application() {

    //Se ejecuta cuando la aplicación es "creada"
    override fun onCreate() {
        super.onCreate()

        // inicializar Firebase Analiticas
        // inicializar Firebase Pushnotifications
        // inicializar ROOM DAO
    }

}