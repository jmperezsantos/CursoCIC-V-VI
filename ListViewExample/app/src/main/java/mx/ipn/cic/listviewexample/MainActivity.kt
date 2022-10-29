package mx.ipn.cic.listviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.ipn.cic.listviewexample.fragments.ListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null){

            val transaction = this.supportFragmentManager.beginTransaction()

            val listFragment = ListFragment.newInstance()

            transaction.replace(R.id.fragmentContainer, listFragment)

            transaction.commit()

        }

    }
}