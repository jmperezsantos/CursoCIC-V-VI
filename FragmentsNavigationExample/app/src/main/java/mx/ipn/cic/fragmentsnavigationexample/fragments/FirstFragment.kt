package mx.ipn.cic.fragmentsnavigationexample.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import mx.ipn.cic.fragmentsnavigationexample.R

class FirstFragment : Fragment() {

    lateinit var btnNavega: Button

    /*FirstFragment(){
        super()
        //configuramos la instancia
    }*/

    //Se crea la instancia del fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Ya tenemos Instancia del Fragment
        //Configurar los elementos Lógicos del fragment
        //Inicializar Cliente de WS
        //Inicializar Conector de BD
        //ViewModel

        arguments?.let {

        }
    }

    //Se crea la Interfaz gráfica del Fragment
    override fun onCreateView(
        inflater: LayoutInflater, //Infla la vista
        container: ViewGroup?, // La raiz del contenedor
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(
            R.layout.fragment_first,
            container,
            false
        )
    }

    //Notifica que la Interfaz ya se creó
    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        //Ya tenemos UI
        //Configurar los elementos visuales del fragment

        this.btnNavega = view.findViewById(R.id.btnNavega)
        this.btnNavega.setOnClickListener {

            //Poner fragmento 2
            val fragment2 = SecondFragment.newInstance()

            val transaction = this.parentFragmentManager.beginTransaction()

            transaction.replace(
                R.id.fragmentContainer,
                fragment2
            )

            transaction.addToBackStack("firstFragment")

            transaction.commit()

        }

    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()

        //Lanzar procesos
        //Consumir un WS
        //Consultar BD
        //Mostrar un video
    }

    fun myMethod() {

    }

    fun myMethod2(param1: String, param2: Int): String {
        return "Param1= $param1 Param2=$param2"
    }

    //Para métodos o propiedades "estáticos"
    companion object {

        fun newInstance(): FirstFragment {
            return FirstFragment()
        }
    }
}