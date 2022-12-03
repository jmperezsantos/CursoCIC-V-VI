package mx.ipn.cic.dependencyinjectionexample.hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import mx.ipn.cic.dependencyinjectionexample.services.ProductService
import mx.ipn.cic.dependencyinjectionexample.wsclient.ProductWSClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

@Module
@InstallIn(ActivityComponent::class)
class HiltApplicationModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://diplomadoandroid-b09d9-default-rtdb.firebaseio.com/")//Dominio del WS
            .addConverterFactory(GsonConverterFactory.create())//Definición del interprete de datos
            .build()
    }

    @Provides
    @Inject
    fun provideProductWSClient(
        retrofit: Retrofit
    ): ProductWSClient {
        return retrofit.create(ProductWSClient::class.java)
    }

    @Provides
    @Inject
    fun provideProductService(
        wsClient: ProductWSClient
    ): ProductService {
        return ProductService(wsClient)
    }

}