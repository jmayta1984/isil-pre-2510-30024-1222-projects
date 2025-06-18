package pe.isil.easyshoes.features.favorites.data.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.isil.easyshoes.features.favorites.data.local.FavoriteShoeDao
import pe.isil.easyshoes.features.favorites.data.local.FavoriteShoeDto
import pe.isil.easyshoes.features.favorites.domain.FavoriteShoe

class FavoriteShoeRepository (private val favoriteShoeDao: FavoriteShoeDao) {

    suspend fun insertFavoriteShoe(favoriteShoe: FavoriteShoe)  = withContext(Dispatchers.IO){
        favoriteShoeDao.insertFavorite(FavoriteShoeDto(
            id = favoriteShoe.id,
            name = favoriteShoe.name,
            image = favoriteShoe.image,
            price = favoriteShoe.price
        ));
    }
    suspend fun deleteFavoriteShoe(favoriteShoe: FavoriteShoe)  = withContext(Dispatchers.IO){
        favoriteShoeDao.deleteFavorite(FavoriteShoeDto(
            id = favoriteShoe.id,
            name = favoriteShoe.name,
            image = favoriteShoe.image,
            price = favoriteShoe.price
        ));
    }

    suspend fun fetchAllFavoriteShoes(): List<FavoriteShoe> = withContext(Dispatchers.IO) {
        favoriteShoeDao.fetchAllFavorites().map { favoriteShoeDto ->
            FavoriteShoe(
                id = favoriteShoeDto.id,
                name = favoriteShoeDto.name,
                image = favoriteShoeDto.image,
                price = favoriteShoeDto.price
            )
        }
    }
}