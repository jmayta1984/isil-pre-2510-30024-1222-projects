package pe.isil.easyshoes.features.favorites.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FavoriteShoeDto::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getFavoriteShoeDao(): FavoriteShoeDao
}