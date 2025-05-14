package pe.isil.inventorycompose.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import pe.isil.inventorycompose.domain.model.Product
import java.util.UUID

class ProductDetailViewModel() : ViewModel() {
    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name

    private val _quantity = MutableStateFlow("")
    val quantity: StateFlow<String> = _quantity

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    fun updateName(name: String){
        _name.value = name
    }

    fun updateQuantity(quantity: String){
        _quantity.value = quantity
    }

    fun validate(id: String?): Product? {

        if (name.value.isEmpty()){
            _errorMessage.value = "Name is empty"
            return null
        }

        if (quantity.value.isEmpty()){
            _errorMessage.value = "Quantity is empty"
            return null
        }

        quantity.value.toIntOrNull()?.let {
            _errorMessage.value = null
            return Product(
                id = id ?: UUID.randomUUID().toString(),
                name = name.value,
                quantity = it)
        }

        _errorMessage.value = "Invalid quantity"
        return null

    }
}