package pe.isil.inventorycompose.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ProductDao {

    @Insert
    fun insertProduct(entity: ProductEntity)

    @Update
    fun updateProduct(entity: ProductEntity)

    @Delete
    fun deleteProduct(entity: ProductEntity)

    @Query("select * from products")
    fun fetchProducts(): List<ProductEntity>

}