package pe.isil.inventorycompose.presentation.view

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ProductListView(modifier: Modifier = Modifier) {

    Scaffold (
        floatingActionButton = {
            FloatingActionButton(
                onClick = {

                }
            ) {
                Icon(Icons.Default.Add, contentDescription = null)
            }
        }
    ){ padding ->
        LazyColumn (modifier = modifier.padding(padding)) {

        }
    }

}