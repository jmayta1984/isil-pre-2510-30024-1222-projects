package pe.isil.easyshoes.features.home.data.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.isil.easyshoes.features.favorites.data.local.FavoriteShoeDao
import pe.isil.easyshoes.features.favorites.data.local.FavoriteShoeDto
import pe.isil.easyshoes.features.home.data.remote.ShoeService
import pe.isil.easyshoes.features.home.domain.Shoe

class ShoeRepository(private val shoeService: ShoeService,
    private val favoriteShoeDao: FavoriteShoeDao
    ) {

    suspend fun getShoes(): List<Shoe>  = withContext(Dispatchers.IO){
        val response = shoeService.getShoes()
        val favoriteShoes = favoriteShoeDao.fetchAllFavorites()

        val ids = favoriteShoes.map { it.id }

        if (response.isSuccessful){
            response.body()?.let { shoesDto ->
                return@withContext shoesDto.map { shoeDto ->
                    shoeDto.toDomain(ids.contains(shoeDto.id))
                }.toList()
            }
        }
        return@withContext emptyList()
    }

    suspend fun insertShoe(shoe: Shoe) = withContext(Dispatchers.IO) {

        favoriteShoeDao.insertFavorite(FavoriteShoeDto(
            id = shoe.id,
            name = shoe.name,
            price = shoe.price,
            image = shoe.image,
        ))
    }

    suspend fun deleteShoe(shoe: Shoe) = withContext(Dispatchers.IO) {

        favoriteShoeDao.deleteFavorite(FavoriteShoeDto(
            id = shoe.id,
            name = shoe.name,
            price = shoe.price,
            image = shoe.image,
        ))
    }
}