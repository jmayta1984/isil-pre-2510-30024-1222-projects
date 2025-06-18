package pe.isil.easyshoes.features.home.presentation.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pe.isil.easyshoes.features.home.domain.Shoe

@Composable
fun ShoeCardView(shoe: Shoe, onSelect: () -> Unit) {
    Card(modifier = Modifier.padding(8.dp), onClick = {
        onSelect()
    }) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = shoe.image,
                contentDescription = null,
                modifier = Modifier.size(128.dp)
            )

            Column {
                Text(shoe.name, fontWeight = FontWeight.Bold, maxLines = 1)
                Text(shoe.brand)
                Text("$ ${shoe.price}")
            }

        }
    }
}