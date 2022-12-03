package mx.ipn.cic.dependencyinjectionexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import mx.ipn.cic.dependencyinjectionexample.fragments.ProductListFragment

@AndroidEntryPoint
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