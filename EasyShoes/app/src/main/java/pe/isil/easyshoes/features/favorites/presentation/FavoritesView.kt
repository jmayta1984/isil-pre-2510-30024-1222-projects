package pe.isil.easyshoes.features.favorites.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pe.isil.easyshoes.features.favorites.domain.FavoriteShoe

@Composable
fun FavoritesView() {

    val favorites = listOf<FavoriteShoe>(
        FavoriteShoe(
            id = 1,
            name = "Nike Air Max",
            image = "https://vanidad.es/wp-content/uploads/2024/11/Captura_de_Pantalla_2024-10-08_a_las_14.33_.52-removebg-preview_.png",
            price = 120
        ),
        FavoriteShoe(
            id = 2,
            name = "Nike Air Max",
            image = "https://vanidad.es/wp-content/uploads/2024/11/Captura_de_Pantalla_2024-10-08_a_las_14.33_.52-removebg-preview_.png",
            price = 120
        ),
        FavoriteShoe(
            id = 3,
            name = "Nike Air Max",
            image = "https://vanidad.es/wp-content/uploads/2024/11/Captura_de_Pantalla_2024-10-08_a_las_14.33_.52-removebg-preview_.png",
            price = 120
        ),
        FavoriteShoe(
            id = 4,
            name = "Nike Air Max",
            image = "https://vanidad.es/wp-content/uploads/2024/11/Captura_de_Pantalla_2024-10-08_a_las_14.33_.52-removebg-preview_.png",
            price = 120
        ),
        )
    Scaffold {
        padding ->
        LazyColumn (modifier = Modifier.padding()) {
            items(favorites) { favorite ->
                FavoriteShoeCardView(favorite = favorite)
            }
        }
    }

}