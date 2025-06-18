package pe.isil.easyshoes.features.favorites.presentation.di

import pe.isil.easyshoes.features.favorites.data.di.DataModule
import pe.isil.easyshoes.features.favorites.presentation.viewmodels.FavoritesViewModel

object PresentationModule {

    fun getFavoriteShoeViewModel(): FavoritesViewModel {
        return FavoritesViewModel(favoriteShoeRepository = DataModule.getFavoriteShoeRepository())
    }
}