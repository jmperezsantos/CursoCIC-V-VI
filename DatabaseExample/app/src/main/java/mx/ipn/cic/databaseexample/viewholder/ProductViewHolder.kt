package mx.ipn.cic.databaseexample.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mx.ipn.cic.databaseexample.R
import mx.ipn.cic.databaseexample.entity.ProductEntity

class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvName: TextView = view.findViewById(R.id.tvName)
    private val tvPrice: TextView = view.findViewById(R.id.tvPrice)
    private val ivImage: ImageView = view.findViewById(R.id.ivProduct)

    fun bindProduct(productEntity: ProductEntity) {

        tvName.text = productEntity.name
        tvPrice.text = "$ ${productEntity.price}"

        //TODO Cargar imagen

    }

}