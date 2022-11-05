package mx.ipn.cic.webserviceexample.wsclient

import mx.ipn.cic.webserviceexample.dto.ProductDTO
import retrofit2.Call
import retrofit2.http.GET

//Cliente de WS (homologo a Postman)
interface ProductWSClient {

    @GET("products.json")
    fun getAllProducts(): Call<Map<String, ProductDTO>>

}