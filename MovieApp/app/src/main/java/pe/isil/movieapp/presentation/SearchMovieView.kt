package pe.isil.movieapp.presentation

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pe.isil.movieapp.domain.Movie
import kotlin.math.sin

@Composable

fun SearchMovieView(
    viewModel: SearchMovieViewModel,
    onSelect: (Movie) -> Unit = {}
){
    val query = remember {
        mutableStateOf("")
    }

    val movies = viewModel.movies.collectAsState()


    Column(modifier = Modifier.fillMaxSize()) {
        OutlinedTextField(
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            modifier = Modifier.fillMaxWidth(),
            value = query.value, onValueChange = { query.value = it })

        ElevatedButton(onClick = {
            Log.d("SearchMovieView", "getMovies: ${query.value}")
            viewModel.getMovies(query.value)
        }, modifier =  Modifier.fillMaxWidth()) {
            Text("Search")
        }
        LazyColumn {
            items(movies.value) { movie ->
                Card (
                    modifier = Modifier.padding(8.dp),
                    onClick = {
                    onSelect(movie)
                }){
                    Row (modifier = Modifier.fillMaxWidth()){
                        AsyncImage(
                            movie.poster,
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(92.dp)
                        )
                        Text(movie.title)

                    }

                }
            }
        }
    }
}