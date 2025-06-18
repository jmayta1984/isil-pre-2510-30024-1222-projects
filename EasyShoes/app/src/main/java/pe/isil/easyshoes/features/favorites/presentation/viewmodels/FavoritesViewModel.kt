package pe.isil.easyshoes.features.favorites.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.isil.easyshoes.features.favorites.data.repositories.FavoriteShoeRepository
import pe.isil.easyshoes.features.favorites.domain.FavoriteShoe

class FavoritesViewModel(private val favoriteShoeRepository: FavoriteShoeRepository) : ViewModel() {

    private val _favoriteShoes = MutableStateFlow<List<FavoriteShoe>>(emptyList())
    val favoriteShoes: StateFlow<List<FavoriteShoe>> get() = _favoriteShoes

    fun getFavoriteShoes() {
        viewModelScope.launch {
            _favoriteShoes.value = favoriteShoeRepository.fetchAllFavoriteShoes()
        }
    }

    fun removeFavoriteShoe(favoriteShoe: FavoriteShoe) {
        viewModelScope.launch {
            favoriteShoeRepository.deleteFavoriteShoe(favoriteShoe)
            getFavoriteShoes() // Refresh the list after deletion
        }
    }
}