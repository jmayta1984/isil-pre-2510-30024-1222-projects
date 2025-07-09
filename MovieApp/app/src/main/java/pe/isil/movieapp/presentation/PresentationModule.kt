package pe.isil.movieapp.presentation

import pe.isil.movieapp.data.DataModule.getMovieService

object PresentationModule {

    fun getSearchMovieViewModel(): SearchMovieViewModel{
        return SearchMovieViewModel(getMovieService())
    }
}