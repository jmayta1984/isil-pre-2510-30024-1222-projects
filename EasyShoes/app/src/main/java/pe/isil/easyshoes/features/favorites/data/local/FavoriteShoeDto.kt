package pe.isil.easyshoes.features.favorites.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class FavoriteShoeDto(
    @PrimaryKey
    val id: Int,
    val name: String,
    val image: String,
    val price: Int
)
