package pe.isil.movieapp.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()

    val navigationItems = listOf(
        NavigationItem(
            name = "Search",
            icon = Icons.Default.Search,
            route = "search_movie"
        ),
        NavigationItem(
            name = "Favorites",
            icon = Icons.Default.Favorite,
            route = "favorites"
        )
    )

    Scaffold (
        bottomBar = {
            NavigationBar {

            }
        }
    )

    { padding ->
        NavHost(navController, startDestination = "search_movie", modifier = Modifier.padding(padding)) {
            composable("search_movie") {

            }
            composable("detail_movie") {

            }
            composable("favorites") {

            }
        }
    }

}

data class NavigationItem(
    val name: String,
    val icon: ImageVector,
    val route: String
)