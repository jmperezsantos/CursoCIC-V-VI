package mx.ipn.cic.databaseexample.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import mx.ipn.cic.databaseexample.entity.ProductEntity

@Dao
interface ProductDAO {

    @Query("SELECT * FROM product")
    fun getAllProducts(): List<ProductEntity>

    @Query("SELECT * FROM product WHERE name LIKE :productName")
    fun findByName(productName: String): List<ProductEntity>

    @Query("UPDATE product set price = :newPrice WHERE product_type = :productType")
    fun updatePrice(newPrice: Double, productType: Int)

    @Insert
    fun insertProduct(product: ProductEntity)

    @Update
    fun update(product: ProductEntity)

    @Delete
    fun delete(product: ProductEntity)

}