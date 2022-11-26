package mx.ipn.cic.viewbindingexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import mx.ipn.cic.viewbindingexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //activity_main.xml -> ActivityMainBinding
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.viewBinding =
            ActivityMainBinding.inflate(this.layoutInflater)

        setContentView(this.viewBinding.root)

        this.viewBinding.tvTitle.text = "Hello ViewBinding!!"
        this.viewBinding.etUsername.hint = "Otro placeholder"

        this.viewBinding.btnLogin.setOnClickListener {

            Snackbar.make(
                this.viewBinding.root,
                "Texto: ${this.viewBinding.etUsername.text}",
                Snackbar.LENGTH_LONG
            ).show()

        }
    }
}