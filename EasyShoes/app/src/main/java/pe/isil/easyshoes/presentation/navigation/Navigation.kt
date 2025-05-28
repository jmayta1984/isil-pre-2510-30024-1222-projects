package pe.isil.easyshoes.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
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

@Preview
@Composable
fun Navigation() {
    val navController = rememberNavController()

    val navigationItems = listOf(
        NavigationItem(name = "Home", icon = Icons.Default.Home, route = "home"),
        NavigationItem(name = "Favorites", icon = Icons.Default.Favorite, route = "favorites"),
        NavigationItem(name = "Cart", icon = Icons.Default.ShoppingCart, route = "cart"),
        NavigationItem(name = "Profile", icon = Icons.Default.Person, route = "profile")

    )

    val selectedIndex = remember {
        mutableStateOf(0)
    }
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
                            Icon(item.icon, contentDescription = null)
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
            composable("home") {}
            composable("product_detail") {}
            composable("favorites") { }
            composable("cart") {}
            composable("profile") {}
        }
    }

}

data class NavigationItem(
    val name: String,
    val icon: ImageVector,
    val route: String
)