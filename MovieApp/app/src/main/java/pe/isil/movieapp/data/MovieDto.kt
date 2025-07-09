package pe.isil.movieapp.data

import com.google.gson.annotations.SerializedName

data class MovieDto(
    val id: Int,
    val title: String,
    @SerializedName("poster_path")
    val poster: String,
    val overview: String
)
