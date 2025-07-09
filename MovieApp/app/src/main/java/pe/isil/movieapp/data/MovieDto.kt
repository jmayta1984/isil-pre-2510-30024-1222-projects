package pe.isil.movieapp.data

import com.google.gson.annotations.SerializedName
import pe.isil.movieapp.domain.Movie

data class MovieDto(
    val id: Int,
    val title: String,
    @SerializedName("poster_path")
    val poster: String,
    val overview: String
) {
    fun toDomain(): Movie {
        return Movie (
            id = id,
            title = title,
            poster = "https://image.tmdb.org/t/p/w500${poster}",
            overview = overview
        )
    }
}

data class MoviesDto(
    @SerializedName("results")
    val movies: List<Movie>
)