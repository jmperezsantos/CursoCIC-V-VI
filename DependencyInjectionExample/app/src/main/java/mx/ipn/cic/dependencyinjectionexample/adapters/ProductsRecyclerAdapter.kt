package mx.ipn.cic.dependencyinjectionexample.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mx.ipn.cic.dependencyinjectionexample.R
import mx.ipn.cic.dependencyinjectionexample.dto.ProductDTO
import mx.ipn.cic.dependencyinjectionexample.viewholder.ProductViewHolder

class ProductsRecyclerAdapter(
    val products: List<ProductDTO>,
    val onItemClick: (ProductDTO) -> Unit
) : RecyclerView.Adapter<ProductViewHolder>() {

    //La cantidad de elementos a desplegar
    override fun getItemCount(): Int {
        return this.products.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val productCard = inflater.inflate(
            R.layout.product_grid_item,
            parent,
            false
        )

        val viewHolder = ProductViewHolder(productCard)

        return viewHolder
    }

    override fun onBindViewHolder(
        holder: ProductViewHolder,
        position: Int
    ) {

        val product = this.products[position]
        holder.bindProduct(product)

        holder.itemView.setOnClickListener {
            onItemClick(product)
        }

    }


}