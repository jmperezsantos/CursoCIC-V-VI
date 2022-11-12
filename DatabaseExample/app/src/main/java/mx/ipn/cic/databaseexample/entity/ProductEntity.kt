package mx.ipn.cic.databaseexample.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "product")
data class ProductEntity(
    @PrimaryKey var uid: Int,
    @ColumnInfo(name = "image") var image: String, //contact_image
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "price") var price: Double,
    @ColumnInfo(name = "product_type") var productType: Int
) : Serializable {
    override fun toString(): String {
        return "ProductDTO(id=$uid, image='$image', name='$name', price=$price)"
    }
}
