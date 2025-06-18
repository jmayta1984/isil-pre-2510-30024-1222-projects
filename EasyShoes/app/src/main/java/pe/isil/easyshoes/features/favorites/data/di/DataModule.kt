package pe.isil.easyshoes.features.favorites.data.di

import androidx.room.Room
import pe.isil.easyshoes.EasyShoesApplication
import pe.isil.easyshoes.features.favorites.data.local.AppDatabase
import pe.isil.easyshoes.features.favorites.data.local.FavoriteShoeDao
import pe.isil.easyshoes.features.favorites.data.repositories.FavoriteShoeRepository

object DataModule {

   fun getFavoriteShoeRepository(): FavoriteShoeRepository {
       return FavoriteShoeRepository(favoriteShoeDao = getFavoriteShoeDao())
   }

    fun getFavoriteShoeDao(): FavoriteShoeDao {
        return getAppDatabase().getFavoriteShoeDao()
    }

    fun getAppDatabase(): AppDatabase {
        return Room.databaseBuilder(
            EasyShoesApplication.instance.applicationContext,
            AppDatabase::class.java,
            "easyshoes"
        ).build()
    }
}