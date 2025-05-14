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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.isil.inventorycompose.domain.model.Product
import java.util.UUID

@Composable
fun ProductDetailView(
    modifier: Modifier = Modifier,
    selectedProduct: Product?,
    onSave: (Product) -> Unit,
    onBack: () -> Unit
) {

    val name = remember {
        mutableStateOf(selectedProduct?.name ?: "")
    }

    val quantity = remember {
        mutableStateOf(selectedProduct?.quantity?.toString() ?: "")
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    quantity.value.toIntOrNull()?.let { it ->
                        val product = Product(
                            id = selectedProduct?.id ?: UUID.randomUUID().toString(),
                            name = name.value,
                            quantity = it
                        )
                        onSave(product)
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
                    name.value = it
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
                    quantity.value = it
                },
                placeholder = {
                    Text("Quantity")
                },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

        }
    }
}