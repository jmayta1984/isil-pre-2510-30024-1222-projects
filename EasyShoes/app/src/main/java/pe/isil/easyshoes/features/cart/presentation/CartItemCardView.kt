package pe.isil.easyshoes.features.cart.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pe.isil.easyshoes.features.cart.domain.CartItem

@Composable
fun CartItemCardView(
    item: CartItem
) {
    Card(modifier = Modifier.padding(8.dp), onClick = {
    }) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = item.image,
                contentDescription = null,
                modifier = Modifier.size(128.dp)
            )

            Column (modifier = Modifier.weight(1f)) {
                Text(item.name, fontWeight = FontWeight.Bold, maxLines = 1)
                Text("$ ${item.price}")

            }

            IconButton(onClick = {}) {
                Icon(Icons.Default.MoreVert, contentDescription = null)
            }

        }
    }
}