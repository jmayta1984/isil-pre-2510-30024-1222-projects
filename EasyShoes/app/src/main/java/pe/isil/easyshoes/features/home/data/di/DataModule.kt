package pe.isil.easyshoes.features.home.data.di

import pe.isil.easyshoes.features.favorites.data.di.DataModule.getFavoriteShoeDao
import pe.isil.easyshoes.features.home.data.remote.ApiConstants
import pe.isil.easyshoes.features.home.data.remote.ShoeService
import pe.isil.easyshoes.features.home.data.repositories.ShoeRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataModule {

    fun getShoeRepository(): ShoeRepository {
        return ShoeRepository(getShoeService(), getFavoriteShoeDao())
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