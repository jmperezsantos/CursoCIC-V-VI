package mx.ipn.cic.viewbindingexample.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import mx.ipn.cic.viewbindingexample.R
import mx.ipn.cic.viewbindingexample.databinding.FragmentFirstBinding
import mx.ipn.cic.viewbindingexample.model.ProductDTO

class FirstFragment : Fragment() {

    private lateinit var viewBinding: FragmentFirstBinding

    private lateinit
    var producto: ProductDTO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }

        this.producto = ProductDTO(
            "ID DUMMY",
            "Coca Cola 2 Lts.",
            30.0,
            true
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        this.viewBinding = FragmentFirstBinding.inflate(
            inflater,
            container,
            false
        )

        this.viewBinding.product = this.producto

        return this.viewBinding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        this.viewBinding.cbActivo.text = "Producto a la venta"

        this.viewBinding.btnLogin.setOnClickListener {

            Log.i("MPS", "${this.producto}")

        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FirstFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}