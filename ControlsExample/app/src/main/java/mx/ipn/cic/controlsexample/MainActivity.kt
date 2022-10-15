package mx.ipn.cic.controlsexample

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.SwitchCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {

    var counter = 0
    lateinit var etInput: EditText

    private val TAG: String = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        test1()
        test2()
        test3()
        test4()
    }

    private fun test4() {

        val pbProgreso: ProgressBar = findViewById(R.id.pbProgress)
        pbProgreso.progress = 50

        val sSlider: Slider = findViewById(R.id.sSlider)
        sSlider.addOnChangeListener { slider, value, fromUser ->
            Log.d(TAG, "Slider Value: $value")

            pbProgreso.progress = value.toInt() * 10
        }

        val imagen: ImageView = findViewById(R.id.ivImage)
        imagen.setImageResource(R.drawable.message)

        val imageButton: ImageButton = findViewById(R.id.ibImageButton)
        imageButton.setImageResource(R.drawable.message)

        imageButton.setOnClickListener {
            Log.i(TAG, "Image Button Presionado")
            imagen.setImageResource(R.drawable.andy)
        }

        val fabCallToAction = findViewById<FloatingActionButton>(R.id.fabCallToSupport)
        fabCallToAction.setOnLongClickListener {

            Toast.makeText(
                this,
                "Llamando a soporte ...",
                Toast.LENGTH_LONG
            ).show()

            true
        }

    }

    private fun test3() {

        val opciones: RadioGroup = findViewById(R.id.rgOptions)

        opciones.setOnCheckedChangeListener { radioGroup, selected ->

            when (selected) {
                R.id.rbUno -> {
                    Log.d(TAG, "Seleccionó UNO")
                }
                R.id.rbDos -> {
                    Log.d(TAG, "Seleccionó DOS")
                }
                R.id.rbTres -> {
                    Log.d(TAG, "Seleccionó TRES")
                }
                else -> { //default
                    Log.d(TAG, "Esto no debería pasar")
                }
            }

        }

    }

    private fun test2() {

        val swSwitch = findViewById<SwitchCompat>(R.id.swSwitch)
        val checkbox: CheckBox = findViewById(R.id.cbCheck)

        swSwitch.setOnCheckedChangeListener { theSwitch, isActive ->
            if (isActive) {
                theSwitch.text = "Activado"
            } else {
                theSwitch.text = "Apagado"
            }
        }

        checkbox.setOnCheckedChangeListener { theCheckbox, isOn ->

            this.etInput.isEnabled = isOn

        }

    }

    private fun test1() {

        val miTextoPrincipal = findViewById<TextView>(R.id.tvTextoPrincipal)
        var tvTextoSecundario = findViewById<TextView>(R.id.tvTextoSecundario)

        this.etInput = findViewById(R.id.etInputText)

        val btnContine: Button = findViewById(R.id.btnContinue)

        btnContine.setOnClickListener {

            counter++

            miTextoPrincipal.text = "El botón fue presionado $counter"

            Toast.makeText(
                this, "Botón Presionado", Toast.LENGTH_LONG
            ).show()

            //Obtenemos el contenido del EditText y lo
            // mostramos en el TextView
            val cadenaX: String = etInput.text.toString()
            tvTextoSecundario.text = cadenaX


            //Se limpia el contenido del EditText
            etInput.setText("")

        }
    }
}