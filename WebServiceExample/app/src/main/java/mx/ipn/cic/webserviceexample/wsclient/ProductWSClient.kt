package mx.ipn.cic.webserviceexample.wsclient

import mx.ipn.cic.webserviceexample.dto.ProductDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

//Cliente de WS (homologo a Postman)
interface ProductWSClient {

    @GET("products.json")
    fun getAllProducts(): Call<Map<String, ProductDTO>>

    @POST("products.json")
    fun createProduct(
        @Body product: ProductDTO
    ): Call<Map<String, String>>

    @DELETE("products/{productId}.json")
    fun deleteProduct(
        @Path("productId") productId: String,
    ): Call<Void>

}