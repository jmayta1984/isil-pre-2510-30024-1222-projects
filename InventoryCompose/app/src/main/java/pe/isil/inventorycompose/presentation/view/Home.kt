package pe.isil.inventorycompose.presentation.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.isil.inventorycompose.domain.model.Product

@Preview
@Composable
fun Home() {
    val navController = rememberNavController()

    val products = remember {
        mutableStateOf<List<Product>>(emptyList())
    }

    NavHost(navController, startDestination = "product_list") {

        composable("product_list") {
            ProductListView(
                products = products.value,
                onDelete = { product ->
                    products.value = products.value.filterNot {
                        product.name == it.name
                    }
                }) {
                navController.navigate("product_detail")
            }
        }

        composable("product_detail") {
            ProductDetailView(onSave = { product ->
                products.value += product
            }) {
                navController.popBackStack()
            }
        }

    }

}