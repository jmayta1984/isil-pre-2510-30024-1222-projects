package pe.isil.easyshoes.features.home.presentation.di

import pe.isil.easyshoes.features.home.data.di.DataModule.getShoeRepository
import pe.isil.easyshoes.features.home.presentation.viewmodels.HomeViewModel

object PresentationModule {
    fun getHomeViewModel(): HomeViewModel {
        return HomeViewModel(getShoeRepository())
    }
 }