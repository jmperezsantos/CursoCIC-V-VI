package mx.ipn.cic.webserviceexample.services

import android.util.Log
import mx.ipn.cic.webserviceexample.dto.ProductDTO
import mx.ipn.cic.webserviceexample.wsclient.ProductWSClient
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class ProductService {

    companion object {

        val instance: ProductService = ProductService()

    }

    private val productWSClient: ProductWSClient

    private constructor() {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://diplomadoandroid-b09d9-default-rtdb.firebaseio.com/")//Dominio del WS
            .addConverterFactory(GsonConverterFactory.create())//Definición del interprete de datos
            .build()

        this.productWSClient = retrofit.create(ProductWSClient::class.java)

    }

    fun getAllProducts(
        success: (List<ProductDTO>) -> Unit,
        error: (String) -> Unit
    ) {

        this.productWSClient.getAllProducts()
            .enqueue( //Se ejecuta en segundo plano
                object : Callback<Map<String, ProductDTO>> { //Explicar Clase Anónima

                    //Llamadas exitosas
                    override fun onResponse(
                        call: Call<Map<String, ProductDTO>>,
                        response: Response<Map<String, ProductDTO>>
                    ) {

                        if (response.isSuccessful) {

                            val productList = mutableListOf<ProductDTO>()

                            val productMap = response.body()!!

                            productMap.keys.forEach { clave ->

                                val product = productMap[clave]!!
                                product.id = clave

                                productList.add(product)

                            }

                            success(productList)
                        }

                    }

                    //Llamada fallida
                    override fun onFailure(
                        call: Call<Map<String, ProductDTO>>,
                        err: Throwable
                    ) {
                        Log.e("MPS", "Ocurrió un error: ${err.message}")
                        error(err.message.toString())
                    }

                })

    }

    fun createProduct(
        newProduct: ProductDTO,
        success: (String) -> Unit,
        error: (String) -> Unit
    ) {
        this.productWSClient.createProduct(newProduct)
            .enqueue(object : Callback<Map<String, String>> {
                override fun onResponse(
                    call: Call<Map<String, String>>,
                    response: Response<Map<String, String>>
                ) {

                    if (response.isSuccessful) {
                        val responseMap = response.body()!!
                        success(responseMap["name"]!!)
                    } else {
                        error(response.message())
                    }

                }

                override fun onFailure(call: Call<Map<String, String>>, t: Throwable) {

                    Log.e("MPS", "Ocurrió un error: ${t.message}")
                    error(t.message.toString())
                }

            })
    }

    fun updateProduct(
        product: ProductDTO,
        success: (ProductDTO) -> Unit,
        error: (String) -> Unit
    ) {
        //TODO Consumir WS
    }

    fun deleteProduct(
        productId: String,
        success: () -> Unit,
        error: (String) -> Unit
    ) {

        this.productWSClient.deleteProduct(productId)
            .enqueue(object : Callback<Void> {
                override fun onResponse(
                    call: Call<Void>,
                    response: Response<Void>
                ) {

                    if (response.isSuccessful) {
                        success()
                    } else {
                        error(response.message())
                    }

                }

                override fun onFailure(
                    call: Call<Void>,
                    t: Throwable
                ) {
                    Log.e("MPS", "Ocurrió un error: ${t.message}")
                    error(t.message.toString())
                }
            })

    }

}