package pe.isil.movieapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil3.compose.AsyncImage
import pe.isil.movieapp.domain.Movie

@Composable
fun MovieDetailView(movie: Movie) {
    Scaffold { padding ->
        Column (modifier = Modifier.padding(padding)){
            AsyncImage(movie.poster,contentDescription = null)
            Text(movie.title)
            Text(movie.overview)
        }
    }
}