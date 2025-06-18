package pe.isil.easyshoes.features.home.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.isil.easyshoes.features.home.data.repositories.ShoeRepository
import pe.isil.easyshoes.features.home.domain.Shoe

class HomeViewModel(private val shoeRepository: ShoeRepository): ViewModel() {
    private val _shoes = MutableStateFlow<List<Shoe>>(emptyList())
    val shoes: StateFlow<List<Shoe>> get() = _shoes

    fun getShoes() {
        viewModelScope.launch {
            _shoes.value = shoeRepository.getShoes()
        }

    }
}