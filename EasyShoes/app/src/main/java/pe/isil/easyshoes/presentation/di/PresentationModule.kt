package pe.isil.easyshoes.presentation.di

import pe.isil.easyshoes.data.di.DataModule.getShoeRepository
import pe.isil.easyshoes.presentation.viewmodels.HomeViewModel

object PresentationModule {
    fun getHomeViewModel(): HomeViewModel {
        return HomeViewModel(getShoeRepository())
    }
 }