package pe.isil.inventorycompose.data.di

import androidx.room.Room
import pe.isil.inventorycompose.InventoryApplication
import pe.isil.inventorycompose.data.local.AppDatabase
import pe.isil.inventorycompose.data.local.ProductDao
import pe.isil.inventorycompose.data.repository.ProductRepository

object DataModule {

    fun getProductRepository(): ProductRepository {
        return ProductRepository(getProductDao());
    }

    fun getProductDao(): ProductDao {
        return getAppDatabase().productDao()
    }

    fun getAppDatabase(): AppDatabase {
        return Room
            .databaseBuilder(
                InventoryApplication.instance.applicationContext,
                AppDatabase::class.java,
                "inventory-db"
            )
            .allowMainThreadQueries()
            .build()
    }
}