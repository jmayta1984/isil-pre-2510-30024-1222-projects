package pe.isil.easyshoes.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun HomeView(){
    val search = remember {
        mutableStateOf("")
    }
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
    }
}