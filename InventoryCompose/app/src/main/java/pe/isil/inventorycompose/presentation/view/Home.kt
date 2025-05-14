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

    val selectedProduct = remember {
        mutableStateOf<Product?>(null)
    }

    NavHost(navController, startDestination = "product_list") {

        composable("product_list") {
            ProductListView(
                products = products.value,
                onDelete = { product ->
                    products.value = products.value.filterNot {
                        product.id == it.id
                    }
                },
                onTap = { product ->
                    selectedProduct.value = product
                    navController.navigate("product_detail")
                }
            ) {
                selectedProduct.value = null
                navController.navigate("product_detail")
            }
        }

        composable("product_detail") {
            ProductDetailView(
                selectedProduct = selectedProduct.value,
                onSave = { product ->
                    products.value =
                        if (selectedProduct.value == null) {
                            products.value + product
                        } else {
                            products.value.map { it ->
                                if (it.id == product.id) product else it
                            }
                        }

                }) {
                navController.popBackStack()
            }
        }

    }

}