package mx.ipn.cic.databaseexample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.ipn.cic.databaseexample.fragments.ProductListFragment

class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var context: Context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this

        if (savedInstanceState == null) {
            val fragment = ProductListFragment.newInstance()

            val transaction = this.supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer, fragment)
            transaction.commit()

        }
    }
}