package pe.isil.inventorycompose.data.repository

import pe.isil.inventorycompose.data.local.ProductDao
import pe.isil.inventorycompose.data.local.ProductEntity
import pe.isil.inventorycompose.domain.model.Product

class ProductRepository(private val productDao: ProductDao) {

    fun insertProduct(product: Product) {
        productDao.insertProduct(
            ProductEntity(
                id = product.id,
                name = product.name,
                quantity = product.quantity)
        )
    }

    fun deleteProduct(product: Product) {
        productDao.deleteProduct(
            ProductEntity(
                id = product.id,
                name = product.name,
                quantity = product.quantity)
        )
    }

    fun updateProduct(product: Product) {
        productDao.updateProduct(
            ProductEntity(
                id = product.id,
                name = product.name,
                quantity = product.quantity)
        )
    }

    fun fetchProducts(): List<Product>{
        return productDao.fetchProducts().map { entity ->
            Product(id = entity.id, name =  entity.name, quantity =  entity.quantity)
        }
    }

}