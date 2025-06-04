package pe.isil.easyshoes.data.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.isil.easyshoes.data.remote.ShoeService
import pe.isil.easyshoes.domian.entities.Shoe

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