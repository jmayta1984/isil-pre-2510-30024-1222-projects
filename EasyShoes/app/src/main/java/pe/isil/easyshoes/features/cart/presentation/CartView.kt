package pe.isil.easyshoes.features.cart.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pe.isil.easyshoes.features.cart.domain.CartItem
import pe.isil.easyshoes.features.favorites.domain.FavoriteShoe
import pe.isil.easyshoes.features.favorites.presentation.FavoriteShoeCardView

@Composable
fun CartView() {

    val cartItems = listOf<CartItem>(
        CartItem(
            id = 1,
            name = "Nike Air Max",
            image = "https://vanidad.es/wp-content/uploads/2024/11/Captura_de_Pantalla_2024-10-08_a_las_14.33_.52-removebg-preview_.png",
            price = 120,
            quantity = 1
        ),
        CartItem(
            id = 2,
            name = "Adidas Ultraboost",
            image = "https://vanidad.es/wp-content/uploads/2024/11/Captura_de_Pantalla_2024-10-08_a_las_14.33_.52-removebg-preview_.png",
            price = 150,
            quantity = 2

        ),
        CartItem(
            id = 3,
            name = "Nike Air Max",
            image = "https://vanidad.es/wp-content/uploads/2024/11/Captura_de_Pantalla_2024-10-08_a_las_14.33_.52-removebg-preview_.png",
            price = 120,
            quantity = 1
        ),
        CartItem(
            id = 4,
            name = "Adidas Ultraboost",
            image = "https://vanidad.es/wp-content/uploads/2024/11/Captura_de_Pantalla_2024-10-08_a_las_14.33_.52-removebg-preview_.png",
            price = 150,
            quantity = 2

        ),

        )
    Scaffold { padding ->
        LazyColumn(modifier = Modifier.padding()) {
            items(cartItems) { cartItem ->
                CartItemCardView(item = cartItem)
            }
        }
    }

}