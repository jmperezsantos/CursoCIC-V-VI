package mx.ipn.cic.locationmanagerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.ipn.cic.locationmanagerexample.fragments.LocationFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {

            val locationFragment = LocationFragment.newInstance()

            val transaction = this.supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer, locationFragment)
            transaction.commit()

        }

    }
}