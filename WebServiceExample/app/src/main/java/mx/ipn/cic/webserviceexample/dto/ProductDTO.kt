package mx.ipn.cic.webserviceexample.dto

import java.io.Serializable

data class ProductDTO(
    var id: String?,
    val image: String,
    val name: String,
    val price: Double
) : Serializable {
    override fun toString(): String {
        return "ProductDTO(id=$id, image='$image', name='$name', price=$price)"
    }
}
