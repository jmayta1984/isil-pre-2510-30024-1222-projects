package pe.isil.easyshoes.data.di

import pe.isil.easyshoes.data.remote.ApiConstants
import pe.isil.easyshoes.data.remote.ShoeService
import pe.isil.easyshoes.data.repositories.ShoeRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataModule {

    fun getShoeRepository(): ShoeRepository {
        return ShoeRepository(getShoeService())
    }

    fun getShoeService(): ShoeService {
        return getRetrofit().create(ShoeService::class.java)
    }

    fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}