package pe.isil.easyshoes.presentation.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil3.compose.AsyncImage
import pe.isil.easyshoes.domain.entities.Shoe

@Composable
fun ShoeDetailView(shoe: Shoe) {
    Scaffold { padding ->
        Column (modifier = Modifier.padding(padding)) {
            AsyncImage(
                model = shoe.image,
                contentDescription = null
            )
            Row {
                Text(shoe.name)
                Text("$ ${shoe.price}")


            }

        }
    }
}