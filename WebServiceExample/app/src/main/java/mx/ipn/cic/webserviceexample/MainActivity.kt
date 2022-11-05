package mx.ipn.cic.webserviceexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import mx.ipn.cic.webserviceexample.services.ProductService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ProductService.instance.getAllProducts(
            { productos ->

                Log.i("MPS", "Se obtuvieron ${productos.size} productos")

            },
            { error ->
                Log.e("MPS", "Ocurrió un error: $error")
            })

    }
}