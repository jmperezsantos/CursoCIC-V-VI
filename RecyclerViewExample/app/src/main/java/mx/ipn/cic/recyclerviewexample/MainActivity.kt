package mx.ipn.cic.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.ipn.cic.recyclerviewexample.fragments.RecyclerContactsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {

            val transaction = this.supportFragmentManager.beginTransaction()

            transaction.replace(
                R.id.mainContainer,
                RecyclerContactsFragment.newInstance()
            )

            transaction.commit()

        }

    }
}