package mx.ipn.cic.webserviceexample.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import mx.ipn.cic.webserviceexample.R
import mx.ipn.cic.webserviceexample.dto.ProductDTO
import mx.ipn.cic.webserviceexample.services.ProductService

class ProductEditFragment : Fragment() {

    private lateinit var product: ProductDTO

    private lateinit var tilProductName: TextInputLayout
    private lateinit var tilProductPrice: TextInputLayout

    private lateinit var btnUpdate: Button
    private lateinit var btnDelete: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            this.product = it.getSerializable(PRODUCT_ARG) as ProductDTO
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_edit, container, false)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        this.tilProductName = view.findViewById(R.id.tilProductName)
        this.tilProductName.editText!!.setText(this.product.name)

        this.tilProductPrice = view.findViewById(R.id.tilProductPrice)
        this.tilProductPrice.editText!!.setText(
            "${this.product.price}"
        )

        this.btnUpdate = view.findViewById(R.id.btnUpdate)

        this.btnDelete = view.findViewById(R.id.btnDelete)
        this.btnDelete.setOnClickListener {
            ProductService.instance.deleteProduct(
                this.product.id!!,
                {
                    val snack = Snackbar.make(
                        this.requireView(),
                        "Producto: ${this.product.name} fue eliminado exitosamente",
                        Snackbar.LENGTH_INDEFINITE
                    )
                    snack.setAction("Aceptar") {
                        this.parentFragmentManager.popBackStack()
                    }
                    snack.show()
                },
                { errorMessage ->
                    Toast.makeText(
                        this.context,
                        "Ocurrió un error: $errorMessage",
                        Toast.LENGTH_LONG
                    ).show()
                }
            )
        }

    }

    companion object {

        private const val PRODUCT_ARG = "PRODUCT_ARG"

        @JvmStatic
        fun newInstance(product: ProductDTO) =
            ProductEditFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(PRODUCT_ARG, product)
                }
            }
    }
}