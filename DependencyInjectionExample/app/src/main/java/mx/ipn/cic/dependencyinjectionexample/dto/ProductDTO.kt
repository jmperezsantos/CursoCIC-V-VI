package mx.ipn.cic.dependencyinjectionexample.dto

import java.io.Serializable

data class ProductDTO(
    //Se ignora la propiedad al momento de generar el JSON
    @Transient var id: String?,
    var image: String,
    var name: String,
    var price: Double
) : Serializable {
    override fun toString(): String {
        return "ProductDTO(id=$id, image='$image', name='$name', price=$price)"
    }
}
