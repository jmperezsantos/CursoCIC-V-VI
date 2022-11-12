package mx.ipn.cic.databaseexample.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mx.ipn.cic.databaseexample.R
import mx.ipn.cic.databaseexample.entity.ProductEntity
import mx.ipn.cic.databaseexample.viewholder.ProductViewHolder

class ProductsRecyclerAdapter(
    val products: List<ProductEntity>,
    val onItemClick: (ProductEntity) -> Unit
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