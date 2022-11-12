package mx.ipn.cic.databaseexample.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.room.Room
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import mx.ipn.cic.databaseexample.R
import mx.ipn.cic.databaseexample.entity.ProductEntity
import mx.ipn.cic.databaseexample.services.ProductService
import kotlin.random.Random

class ProductFormFragment : Fragment() {

    private lateinit var tilProductName: TextInputLayout
    private lateinit var tilProductPrice: TextInputLayout
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.tilProductName = view.findViewById(R.id.tilProductName)
        this.tilProductPrice = view.findViewById(R.id.tilProductPrice)
        this.btnSave = view.findViewById(R.id.btnSave)

        this.btnSave.setOnClickListener {
            this.saveProduct()
        }

    }

    private fun saveProduct() {

        //TODO hacer validaciones para el almacenamiento del producto
        //TODO validar que ingrese un nombre de producto
        //TODO validar que ingrese un precio

        val product = ProductEntity(
            Random.Default.nextInt(),
            "",
            this.tilProductName.editText!!.text.toString(),
            this.tilProductPrice.editText!!.text.toString().toDouble()
        )
        ProductService.instance.createProduct(
            product,
            {

                val snackbar = Snackbar.make(
                    this.requireView(),
                    "Producto Creado exitosamente!! Id: $it",
                    Snackbar.LENGTH_INDEFINITE
                )
                snackbar.setAction("Aceptar") {
                    this.parentFragmentManager.popBackStack()
                }
                snackbar.show()

            },
            {
                Toast.makeText(
                    this.context,
                    "Error al crear producto: $it",
                    Toast.LENGTH_LONG
                ).show()
            }
        )
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ProductFormFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}