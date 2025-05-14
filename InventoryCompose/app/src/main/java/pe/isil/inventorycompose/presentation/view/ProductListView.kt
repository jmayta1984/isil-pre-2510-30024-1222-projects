package pe.isil.inventorycompose.presentation.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import pe.isil.inventorycompose.domain.model.Product
import pe.isil.inventorycompose.presentation.viewmodel.ProductListViewModel

@Composable
fun ProductListView(
    modifier: Modifier = Modifier,
    viewModel: ProductListViewModel,
    onTap: (Product) -> Unit,
    onAdd: () -> Unit = {}
) {

    val products = viewModel.products.collectAsState()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onAdd()
                }
            ) {
                Icon(Icons.Default.Add, contentDescription = null)
            }
        }
    ) { padding ->
        LazyColumn(modifier = modifier.padding(padding)) {
            items(products.value) { product ->
                ProductListItemView(product, onTap = {
                    onTap(product)
                }) { it ->
                    viewModel.deleteProduct(product)
                }
            }
        }
    }
}

@Composable
fun ProductListItemView(
    product: Product,
    onTap: () -> Unit = {},
    onDelete: (Product) -> Unit = {}
) {
    Card(
        modifier = Modifier.padding(8.dp),
        onClick = {
            onTap()
        }
        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(product.name, fontWeight = FontWeight.Bold)
                Text("${product.quantity}")
            }

            IconButton(
                onClick = {
                    onDelete(product)
                }
            ) {
                Icon(Icons.Default.Delete, contentDescription = null)
            }
        }
    }
}
