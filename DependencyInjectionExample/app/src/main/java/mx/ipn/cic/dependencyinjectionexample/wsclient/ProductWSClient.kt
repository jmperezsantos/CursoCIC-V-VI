package mx.ipn.cic.dependencyinjectionexample.wsclient

import mx.ipn.cic.dependencyinjectionexample.dto.ProductDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

//Cliente de WS (homologo a Postman)
interface ProductWSClient {

    @GET("products.json")
    fun getAllProducts(): Call<Map<String, ProductDTO>>

    @POST("products.json")
    fun createProduct(
        @Body product: ProductDTO
    ): Call<Map<String, String>>

    @PUT("products/{productId}.json")
    fun updateProduct(
        @Body product: ProductDTO,
        @Path("productId") productId: String
    ): Call<ProductDTO>

    @DELETE("products/{productId}.json")
    fun deleteProduct(
        @Path("productId") productId: String,
    ): Call<Void>

}