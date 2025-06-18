package pe.isil.easyshoes.features.favorites.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavoriteShoeDao {

    @Insert
    suspend fun insertFavorite(favorite: FavoriteShoeDto)

    @Delete
    suspend fun deleteFavorite(favorite: FavoriteShoeDto)

    @Query("SELECT * FROM favorites")
    fun fetchAllFavorites(): List<FavoriteShoeDto>
}