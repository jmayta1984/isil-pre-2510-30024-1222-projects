package pe.isil.inventorycompose.presentation.view

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Home() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "product_list") {

        composable("product_list") {
            ProductListView()
        }

        composable("product_detail") {
            ProductDetailView()
        }

    }

}