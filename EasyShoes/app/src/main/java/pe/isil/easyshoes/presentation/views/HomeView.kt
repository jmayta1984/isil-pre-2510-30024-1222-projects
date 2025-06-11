package pe.isil.easyshoes.presentation.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pe.isil.easyshoes.presentation.viewmodels.HomeViewModel


@Composable
fun HomeView(viewModel: HomeViewModel){
    val search = remember {
        mutableStateOf("")
    }

    val shoes = viewModel.shoes.collectAsState()
    viewModel.getShoes()


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
            items(shoes.value) {
                Card (modifier = Modifier.padding(8.dp)) {
                    Row (modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AsyncImage(
                            model = it.image,
                            contentDescription = null,
                            modifier = Modifier.size(128.dp)
                        )

                        Column {
                            Text(it.name, fontWeight = FontWeight.Bold, maxLines = 1)
                            Text(it.brand)
                            Text("$ ${it.price}")
                        }

                    }
                }
            }
        }
    }
}