package pe.isil.movieapp.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.isil.movieapp.data.MovieService
import pe.isil.movieapp.domain.Movie

class SearchMovieViewModel(private val movieService: MovieService): ViewModel() {

    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies: StateFlow<List<Movie>> = _movies

    fun getMovies(query: String ){

        viewModelScope.launch {
            val response = movieService.searchMovie(route = "movie", query = query)
            Log.d("SearchMovieViewModel", response.toString())

            if (response.isSuccessful) {
                response.body()?.let { moviesDto ->
                    _movies.value = moviesDto.movies.map { movieDto ->
                        movieDto.toDomain()
                    }
                }

            }

        }

    }
}