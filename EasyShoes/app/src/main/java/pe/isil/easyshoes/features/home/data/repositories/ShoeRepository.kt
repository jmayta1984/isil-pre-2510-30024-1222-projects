package pe.isil.easyshoes.features.home.data.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.isil.easyshoes.features.home.data.remote.ShoeService
import pe.isil.easyshoes.features.home.domain.entities.Shoe

class ShoeRepository(private val shoeService: ShoeService) {

    suspend fun getShoes(): List<Shoe>  = withContext(Dispatchers.IO){
        val response = shoeService.getShoes()
        if (response.isSuccessful){
            response.body()?.let { shoesDto ->
                return@withContext shoesDto.map { shoeDto ->
                    shoeDto.toDomain()
                }.toList()
            }
        }
        return@withContext emptyList()
    }
}