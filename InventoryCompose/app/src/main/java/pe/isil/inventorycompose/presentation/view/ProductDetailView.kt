package pe.isil.inventorycompose.presentation.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import pe.isil.inventorycompose.domain.model.Product
import pe.isil.inventorycompose.presentation.viewmodel.ProductDetailViewModel
import java.util.UUID

@Composable
fun ProductDetailView(
    modifier: Modifier = Modifier,
    viewModel: ProductDetailViewModel,
    selectedProduct: Product?,
    onSave: (Product) -> Unit,
    onBack: () -> Unit
) {

    val name = viewModel.name.collectAsState()
    val quantity = viewModel.quantity.collectAsState()
    val error = viewModel.errorMessage.collectAsState()

    viewModel.updateName(selectedProduct?.name ?: "")
    viewModel.updateQuantity(selectedProduct?.quantity?.toString() ?: "")


    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.validate(selectedProduct?.id)?.let { it ->
                        onSave(it)
                        onBack()
                    }
                }
            ) {
                Icon(Icons.Default.Save, contentDescription = null)
            }
        }
    ) { padding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                name.value,
                onValueChange = {
                    viewModel.updateName(it)
                },
                placeholder = {
                    Text("Name")
                },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            OutlinedTextField(
                quantity.value,
                onValueChange = {
                    viewModel.updateQuantity(it)
                },
                placeholder = {
                    Text("Quantity")
                },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            error.value?.let {
                Text(
                    it,
                    modifier = Modifier.padding(8.dp),
                    color = Color.Red
                )
            }

        }
    }
}