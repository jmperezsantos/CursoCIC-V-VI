package mx.ipn.cic.webserviceexample.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import mx.ipn.cic.webserviceexample.R
import mx.ipn.cic.webserviceexample.adapters.ProductsRecyclerAdapter
import mx.ipn.cic.webserviceexample.services.ProductService

class ProductListFragment : Fragment() {

    lateinit var rvProduct: RecyclerView
    lateinit var fabCreate: FloatingActionButton

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
        return inflater.inflate(R.layout.fragment_product_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.rvProduct = view.findViewById(R.id.rvProducts)
        this.rvProduct.layoutManager = GridLayoutManager(
            this.context,
            3
        )

        this.fabCreate = view.findViewById(R.id.fabCreate)
        this.fabCreate.setOnClickListener {

            val transaction = this.parentFragmentManager.beginTransaction()

            transaction.replace(
                R.id.fragmentContainer,
                ProductFormFragment.newInstance()
            )

            transaction.addToBackStack(null)

            transaction.commit()
        }

    }

    //Consumos de WS
    override fun onStart() {
        super.onStart()

        ProductService.instance.getAllProducts(
            { products ->

                val adapter = ProductsRecyclerAdapter(products) { selectedProduct ->

                    val editFragment = ProductEditFragment.newInstance(selectedProduct)

                    val transaction = this.parentFragmentManager.beginTransaction()
                    transaction.replace(
                        R.id.fragmentContainer,
                        editFragment
                    )
                    transaction.addToBackStack(null)

                    transaction.commit()

                }
                this.rvProduct.adapter = adapter

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
        @JvmStatic
        fun newInstance() =
            ProductListFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}