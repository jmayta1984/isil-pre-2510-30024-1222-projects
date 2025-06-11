package pe.isil.easyshoes.features.favorites.presentation

import android.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pe.isil.easyshoes.features.favorites.domain.FavoriteShoe

@Composable
fun FavoriteShoeCardView(
    favorite: FavoriteShoe
) {
    Card(modifier = Modifier.padding(8.dp), onClick = {
    }) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = favorite.image,
                contentDescription = null,
                modifier = Modifier.size(128.dp)
            )

            Column (modifier = Modifier.weight(1f)) {
                Text(favorite.name, fontWeight = FontWeight.Bold, maxLines = 1)
                Text("$ ${favorite.price}")
                OutlinedButton(
                    onClick = {},
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.White,
                        containerColor = Color.Black
                    )
                ) {

                    Text("Add to cart")
                }
            }

            IconButton(onClick = {}) {
                Icon(Icons.Default.MoreVert, contentDescription = null)
            }

        }
    }
}