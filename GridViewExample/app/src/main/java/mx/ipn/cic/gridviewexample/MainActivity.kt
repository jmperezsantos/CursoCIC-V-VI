package mx.ipn.cic.gridviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.ipn.cic.gridviewexample.fragments.GridFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {

            val gridFragment = GridFragment.newInstance()

            val transaction = this.supportFragmentManager.beginTransaction()

            transaction.replace(R.id.mainContainer, gridFragment)

            transaction.commit()

        }

    }
}