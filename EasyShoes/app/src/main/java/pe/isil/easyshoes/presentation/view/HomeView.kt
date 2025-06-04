package pe.isil.easyshoes.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pe.isil.easyshoes.domian.entities.Shoe

@Preview
@Composable
fun HomeView(){
    val search = remember {
        mutableStateOf("")
    }

    val shoes = listOf<Shoe>(
        Shoe(id = 1, name = "Adidas Samba", brand = "Adidas", price = 150,
            image = "https://www.stripe3.com/cdn/shop/files/IH6001_1_FOOTWEAR_Photography_SideLateralCenterView_transparent.png"),
        Shoe(id = 2, name = "Adidas Samba", brand = "Adidas", price = 150,
            image = "https://www.stripe3.com/cdn/shop/files/IH6001_1_FOOTWEAR_Photography_SideLateralCenterView_transparent.png"),
        Shoe(id = 3, name = "Adidas Samba", brand = "Adidas", price = 150,
            image = "https://www.stripe3.com/cdn/shop/files/IH6001_1_FOOTWEAR_Photography_SideLateralCenterView_transparent.png")
    )
    Column (modifier = Modifier.fillMaxSize().padding(8.dp)) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = search.value,
            onValueChange = { search.value = it},
            placeholder = { Text("Search") }
        )

        Row {
            Column {
                Text("Up to 25% OFF")
                Text("ENDS SOON")
                Button(
                    onClick = {

                    }
                ) {
                    Text("Shop now")
                }
            }
        }
        LazyColumn {
            items(shoes) {
                Card  {
                    Column (modifier = Modifier.padding(8.dp)) {
                        AsyncImage(
                            model = it.image,
                            contentDescription = null
                        )
                        Text(it.name, fontWeight = FontWeight.Bold)
                        Text(it.brand)
                        Text("$ ${it.price}")
                    }
                }
            }
        }
    }
}