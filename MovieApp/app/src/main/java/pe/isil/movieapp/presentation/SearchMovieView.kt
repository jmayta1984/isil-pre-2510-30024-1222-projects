package pe.isil.movieapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.isil.movieapp.domain.Movie

@Preview
@Composable

fun SearchMovieView(
    onSelect: (Movie) -> Unit = {}
){
    val query = remember {
        mutableStateOf("")
    }

    val movies = remember {
        mutableStateOf(emptyList<Movie>())
    }


    Column(modifier = Modifier.fillMaxSize()) {
        OutlinedTextField(
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            modifier = Modifier.fillMaxWidth(),
            value = query.value, onValueChange = { query.value = it })

        ElevatedButton(onClick = {}, modifier =  Modifier.fillMaxWidth()) {
            Text("Search")
        }
        LazyColumn {
            items(movies.value) { movie ->
                Card (onClick = {
                    onSelect(movie)
                }){
                    Text(movie.title)

                }
            }
        }
    }
}