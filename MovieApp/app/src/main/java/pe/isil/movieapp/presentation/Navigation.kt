package pe.isil.movieapp.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.isil.movieapp.domain.Movie
import pe.isil.movieapp.presentation.PresentationModule.getSearchMovieViewModel

@Preview
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

    val selectedIndex = remember {
        mutableStateOf(0)
    }

    val selectedMovie = remember {
        mutableStateOf<Movie?>(null)
    }

    Scaffold (
        bottomBar = {
            NavigationBar {
                navigationItems.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = index == selectedIndex.value,
                        icon = {
                            Icon(item.icon, contentDescription = null)
                        },
                        onClick = {
                            selectedIndex.value = index
                            navController.navigate(navigationItems[index].route)
                        },
                        label = {
                            Text(item.name)
                        }
                    )
                }
            }
        }
    )

    { padding ->
        NavHost(navController, startDestination = "search_movie", modifier = Modifier.padding(padding)) {
            composable("search_movie") {
                SearchMovieView(viewModel = getSearchMovieViewModel() ) { movie ->
                    selectedMovie.value = movie
                    navController.navigate("detail_movie")
                }
            }
            composable("detail_movie") {
                selectedMovie.value?.let { movie ->
                    MovieDetailView(movie)
                }
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