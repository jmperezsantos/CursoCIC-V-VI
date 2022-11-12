package mx.ipn.cic.databaseexample.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import mx.ipn.cic.databaseexample.R
import mx.ipn.cic.databaseexample.entity.ProductEntity
import mx.ipn.cic.databaseexample.services.ProductService

class ProductEditFragment : Fragment() {

    private lateinit var product: ProductEntity

    private lateinit var tilProductName: TextInputLayout
    private lateinit var tilProductPrice: TextInputLayout

    private lateinit var btnUpdate: Button
    private lateinit var btnDelete: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            this.product = it.getSerializable(PRODUCT_ARG) as ProductEntity
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
        this.btnUpdate.setOnClickListener {
            this.performUpdate()
        }

        this.btnDelete = view.findViewById(R.id.btnDelete)
        this.btnDelete.setOnClickListener {
            this.performDelete()
        }

    }

    private fun performUpdate() {

        this.product.name = this.tilProductName.editText!!.text.toString()
        this.product.price = this.tilProductPrice.editText!!.text.toString().toDouble()

        ProductService.instance.updateProduct(
            this.product,
            { updatedProduct ->
                val snack = Snackbar.make(
                    this.requireView(),
                    "Producto: ${updatedProduct.name} fue actualizado exitosamente",
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

    private fun performDelete() {
        ProductService.instance.deleteProduct(
            this.product,
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

    companion object {

        private const val PRODUCT_ARG = "PRODUCT_ARG"

        @JvmStatic
        fun newInstance(product: ProductEntity) =
            ProductEditFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(PRODUCT_ARG, product)
                }
            }
    }
}