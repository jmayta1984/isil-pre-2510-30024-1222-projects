package pe.isil.easyshoes.features.home.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pe.isil.easyshoes.features.home.domain.Shoe
import pe.isil.easyshoes.features.home.domain.ShoeSize

@Composable
fun ShoeDetailView(shoe: Shoe) {

    val selectedShoeSize = remember {
        mutableStateOf<ShoeSize?>(null)
    }
    Scaffold(
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            OutlinedButton(
                enabled = selectedShoeSize.value != null,
                onClick = {}, modifier = Modifier.fillMaxWidth()) {
                Text("Add to cart")
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(8.dp)) {
            Box(modifier = Modifier.fillMaxWidth()) {
                AsyncImage(
                    model = shoe.image,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1.5f)

                )
                IconButton(
                    onClick = {},
                    modifier = Modifier.align(Alignment.TopEnd)
                ) {
                    Icon(
                        Icons.Default.FavoriteBorder,
                        contentDescription = null,
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(shoe.name, fontWeight = FontWeight.Bold)

                Text("$ ${shoe.price}", fontWeight = FontWeight.Bold)


            }
            Text(shoe.brand)
            Text(shoe.description)

            Text("Sizes", fontWeight = FontWeight.Bold)

            LazyRow {
                items(shoe.sizes) { size ->
                    val isSelected = selectedShoeSize.value == size

                    Box(modifier = Modifier.padding(8.dp)
                        .size(40.dp)
                        .background(color = if (isSelected) Color.Black else Color.LightGray)
                        .clickable {
                            selectedShoeSize.value = size
                        }, contentAlignment = Alignment.Center) {
                        Text(
                            size.size.toString(),
                            style = TextStyle(
                                color = if (isSelected) Color.White else Color.Gray
                            )
                        )
                    }
                }
            }


        }
    }
}