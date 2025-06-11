package pe.isil.easyshoes.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.sharp.Home
import androidx.compose.material.icons.sharp.Person
import androidx.compose.material.icons.sharp.ShoppingCart
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.isil.easyshoes.domain.entities.Shoe
import pe.isil.easyshoes.presentation.di.PresentationModule.getHomeViewModel
import pe.isil.easyshoes.presentation.views.HomeView
import pe.isil.easyshoes.presentation.views.ShoeDetailView

@Preview
@Composable
fun Navigation() {
    val navController = rememberNavController()

    val navigationItems = listOf(
        NavigationItem(
            name = "Home",
            selectedIcon = Icons.Default.Home,
            icon = Icons.Sharp.Home,
            route = "home"
        ),
        NavigationItem(
            name = "Favorites",
            selectedIcon = Icons.Default.Favorite,
            icon = Icons.Default.FavoriteBorder,
            route = "favorites"
        ),
        NavigationItem(
            name = "Cart",
            selectedIcon = Icons.Default.ShoppingCart,
            icon = Icons.Sharp.ShoppingCart,
            route = "cart"
        ),
        NavigationItem(
            name = "Profile",
            selectedIcon = Icons.Default.Person,
            icon = Icons.Sharp.Person,
            route = "profile"
        )

    )

    val selectedIndex = remember {
        mutableStateOf(0)
    }

    val selectedShoe = remember {
        mutableStateOf<Shoe?>(null)
    }

    val homeViewModel = getHomeViewModel()
    homeViewModel.getShoes()
    Scaffold(
        bottomBar = {
            NavigationBar {
                navigationItems.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = index == selectedIndex.value,
                        onClick = {
                            selectedIndex.value = index
                            navController.navigate(item.route)
                        },
                        icon = {
                            Icon(

                                if (selectedIndex.value == index) {
                                    item.selectedIcon
                                } else {
                                    item.icon
                                }, contentDescription = null,

                            )
                        },
                        label = {
                            Text(item.name)
                        }
                    )
                }
            }
        }
    ) { padding ->
        NavHost(
            modifier = Modifier.padding(padding),
            navController = navController,
            startDestination = "home"
        ) {
            composable("home") {
                HomeView(homeViewModel) {
                    selectedShoe.value = it
                    navController.navigate("product_detail")
                }
            }
            composable("product_detail") {
                selectedShoe.value?.let { shoe ->
                    ShoeDetailView(shoe)
                }
            }
            composable("favorites") { }
            composable("cart") {}
            composable("profile") {}
        }
    }

}

data class NavigationItem(
    val name: String,
    val icon: ImageVector,
    val selectedIcon: ImageVector,
    val route: String
)