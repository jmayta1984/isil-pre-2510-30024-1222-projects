package pe.isil.inventorycompose.presentation.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.isil.inventorycompose.domain.model.Product
import pe.isil.inventorycompose.presentation.viewmodel.ProductDetailViewModel
import pe.isil.inventorycompose.presentation.viewmodel.ProductListViewModel

@Preview
@Composable
fun Home() {
    val navController = rememberNavController()

    val selectedProduct = remember {
        mutableStateOf<Product?>(null)
    }

    val productDetailViewModel: ProductDetailViewModel = viewModel ()
    val productListViewModel: ProductListViewModel = viewModel ()

    NavHost(navController, startDestination = "product_list") {

        composable("product_list") {
            ProductListView(
                viewModel = productListViewModel,
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
                viewModel = productDetailViewModel,
                onSave = { product ->
                        if (selectedProduct.value == null) {
                            productListViewModel.addProduct(product)
                        } else {
                            productListViewModel.updateProduct(product)
                        }

                }) {
                navController.popBackStack()
            }
        }

    }

}