package mx.ipn.cic.databaseexample.services

import androidx.room.Room
import mx.ipn.cic.databaseexample.MainActivity
import mx.ipn.cic.databaseexample.database.AppDatabase
import mx.ipn.cic.databaseexample.database.ProductDAO
import mx.ipn.cic.databaseexample.entity.ProductEntity

class ProductService {

    companion object {

        val instance: ProductService = ProductService()

    }

    //DAO para acceder a la Base de Datos
    private val productDAO: ProductDAO

    private constructor() {

        val database = Room.databaseBuilder(
            MainActivity.context,
            AppDatabase::class.java,
            "product_database"
        )
            .allowMainThreadQueries()
            .build()

        this.productDAO = database.getProductDAO()

    }

    fun getAllProducts(
        success: (List<ProductEntity>) -> Unit,
        error: (String) -> Unit
    ) {

        try {

            val products = this.productDAO.getAllProducts()
            success(products)

        } catch (e: Exception) {
            error(e.message!!)
        }

    }

    fun createProduct(
        newProduct: ProductEntity,
        success: (ProductEntity) -> Unit,
        error: (String) -> Unit
    ) {

        try {

            this.productDAO.insertProduct(newProduct)
            success(newProduct)

        } catch (e: Exception) {
            error(e.message!!)
        }

    }

    fun updateProduct(
        product: ProductEntity,
        success: (ProductEntity) -> Unit,
        error: (String) -> Unit
    ) {

        try {

            this.productDAO.update(product)
            success(product)

        } catch (e: Exception) {
            error(e.message!!)
        }

    }

    fun deleteProduct(
        product: ProductEntity,
        success: () -> Unit,
        error: (String) -> Unit
    ) {
        try {

            this.productDAO.delete(product)
            success()

        } catch (e: Exception) {
            error(e.message!!)
        }

    }

}