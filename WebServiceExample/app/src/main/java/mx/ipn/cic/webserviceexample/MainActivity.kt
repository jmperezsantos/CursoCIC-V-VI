package mx.ipn.cic.webserviceexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import mx.ipn.cic.webserviceexample.fragments.ProductListFragment
import mx.ipn.cic.webserviceexample.services.ProductService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {

            val listFragment = ProductListFragment.newInstance()
            val transaction = this.supportFragmentManager.beginTransaction()

            transaction.replace(R.id.fragmentContainer, listFragment)

            transaction.commit()

        }

    }
}