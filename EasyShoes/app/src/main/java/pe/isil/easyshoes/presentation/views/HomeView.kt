package pe.isil.easyshoes.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.rememberAsyncImagePainter
import pe.isil.easyshoes.R
import pe.isil.easyshoes.domain.entities.Shoe
import pe.isil.easyshoes.presentation.viewmodels.HomeViewModel


@Composable
fun HomeView(
    viewModel: HomeViewModel,
    onSelect: (Shoe) -> Unit
) {
    val search = remember {
        mutableStateOf("")
    }

    val shoes = viewModel.shoes.collectAsState()


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = search.value,
            onValueChange = { search.value = it },
            placeholder = { Text("Search") }
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(red = 255, green = 107, blue = 53))
        ) {
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    "Up to 25% OFF", color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Text("ENDS SOON", color = Color.White)
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                    onClick = {

                    }
                ) {
                    Text("Shop now")
                }
            }
            Image(
                modifier = Modifier.align(Alignment.CenterEnd),
                painter = rememberAsyncImagePainter(R.drawable.banner),
                contentDescription = null
            )
        }
        LazyColumn {
            items(shoes.value) { shoe ->
                ShoeCardView(shoe = shoe) {
                    onSelect(shoe)
                }
            }
        }
    }
}