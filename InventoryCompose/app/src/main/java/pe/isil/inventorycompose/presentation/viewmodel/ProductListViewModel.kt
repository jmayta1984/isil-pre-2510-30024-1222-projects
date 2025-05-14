package pe.isil.inventorycompose.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import pe.isil.inventorycompose.domain.model.Product

class ProductListViewModel : ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    fun addProduct(product: Product) {
        _products.value += product
    }

    fun deleteProduct(product: Product) {
        _products.value = products.value.filterNot {
            product.id == it.id
        }
    }

    fun updateProduct(product: Product) {
        _products.value = products.value.map { it ->
            if (it.id == product.id) product else it
        }
    }
}