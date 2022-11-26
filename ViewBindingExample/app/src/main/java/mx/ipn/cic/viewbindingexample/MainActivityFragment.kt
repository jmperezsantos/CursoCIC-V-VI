package mx.ipn.cic.viewbindingexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.ipn.cic.viewbindingexample.fragment.FirstFragment

class MainActivityFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment)

        if (savedInstanceState == null) {
            val transaction = this.supportFragmentManager.beginTransaction()

            transaction.replace(
                R.id.fragmentContainer,
                FirstFragment.newInstance()
            )
            transaction.commit()
        }
    }
}