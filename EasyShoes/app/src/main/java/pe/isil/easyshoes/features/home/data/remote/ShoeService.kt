package pe.isil.easyshoes.features.home.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface ShoeService {

    @GET("shoes")
    suspend fun getShoes(): Response<List<ShoeDto>>
}