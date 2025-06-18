package pe.isil.easyshoes.features.favorites.presentation.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import pe.isil.easyshoes.features.favorites.domain.FavoriteShoe
import pe.isil.easyshoes.features.favorites.presentation.viewmodels.FavoritesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesView(viewModel: FavoritesViewModel) {
    val favorites = viewModel.favoriteShoes.collectAsState()
    var showOptions = remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    val selectedFavorite = remember { mutableStateOf<FavoriteShoe?>(null) }

    viewModel.getFavoriteShoes()
    Scaffold {
        padding ->
        LazyColumn (modifier = Modifier.padding()) {
            items(favorites.value) { favorite ->
                FavoriteShoeCardView(favorite = favorite) {
                    showOptions.value = true
                    selectedFavorite.value = favorite
                }
            }
        }

        if (showOptions.value) {
            ModalBottomSheet(
                onDismissRequest = {
                    showOptions.value = false
                },
                sheetState = sheetState
            ) {
                Column {
                    Text("Options", modifier = Modifier.padding(8.dp)
                        , fontWeight = FontWeight.Bold)
                    Row (modifier = Modifier.padding(8.dp).clickable{

                        showOptions.value = false
                    }) {
                        Icon(Icons.Default.ShoppingCart, contentDescription = null)
                        Text("Add to cart")
                    }
                    Row (modifier = Modifier.padding(8.dp).clickable{
                        selectedFavorite.value?.let { shoe ->
                            viewModel.removeFavoriteShoe(shoe)
                        }

                        showOptions.value = false
                    }) {
                        Icon(Icons.Default.Delete, contentDescription = null)
                        Text("Remove from favorites")
                    }
                }

            }
        }
    }

}