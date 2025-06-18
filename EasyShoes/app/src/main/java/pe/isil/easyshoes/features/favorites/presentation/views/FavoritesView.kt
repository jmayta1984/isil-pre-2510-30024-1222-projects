package pe.isil.easyshoes.features.favorites.presentation.views

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import pe.isil.easyshoes.features.favorites.presentation.viewmodels.FavoritesViewModel

@Composable
fun FavoritesView(viewModel: FavoritesViewModel) {
    val favorites = viewModel.favoriteShoes.collectAsState()
    viewModel.getFavoriteShoes()
    Scaffold {
        padding ->
        LazyColumn (modifier = Modifier.padding()) {
            items(favorites.value) { favorite ->
                FavoriteShoeCardView(favorite = favorite)
            }
        }
    }

}