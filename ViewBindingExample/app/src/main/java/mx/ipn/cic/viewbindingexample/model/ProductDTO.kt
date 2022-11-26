package mx.ipn.cic.viewbindingexample.model

class ProductDTO(

    var id: String,
    var name: String,
    var price: Double,
    var active: Boolean

) {

    override fun toString(): String {
        return "ProductDTO(id='$id', name='$name', price=$price, isActive=$active)"
    }
}