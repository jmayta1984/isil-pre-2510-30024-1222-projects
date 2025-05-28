package pe.isil.inventorycompose.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import pe.isil.inventorycompose.data.repository.ProductRepository
import pe.isil.inventorycompose.domain.model.Product

class ProductListViewModel (private val repository: ProductRepository): ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products


    fun fetchProducts() {
        _products.value = repository.fetchProducts()
    }

    fun addProduct(product: Product) {
        repository.insertProduct(product)
        fetchProducts()
    }

    fun deleteProduct(product: Product) {
        repository.deleteProduct(product)
        fetchProducts()
    }

    fun updateProduct(product: Product) {
        repository.updateProduct(product)
        fetchProducts()
    }
}