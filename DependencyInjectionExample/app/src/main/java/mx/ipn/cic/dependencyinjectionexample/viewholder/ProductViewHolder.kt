package mx.ipn.cic.dependencyinjectionexample.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mx.ipn.cic.dependencyinjectionexample.R
import mx.ipn.cic.dependencyinjectionexample.dto.ProductDTO

class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvName: TextView = view.findViewById(R.id.tvName)
    private val tvPrice: TextView = view.findViewById(R.id.tvPrice)
    private val ivImage: ImageView = view.findViewById(R.id.ivProduct)

    fun bindProduct(productDTO: ProductDTO) {

        tvName.text = productDTO.name
        tvPrice.text = "$ ${productDTO.price}"

        //TODO Cargar imagen

    }

}