package pe.isil.inventorycompose.presentation.viewmodel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProductDetailViewModel() {
    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name

    private val _quantity = MutableStateFlow("")
    val quantity: StateFlow<String> = _quantity

    fun updateName(name: String){
        _name.value = name
    }

    fun updateQuantity(quantity: String){
        _quantity.value = quantity
    }
}