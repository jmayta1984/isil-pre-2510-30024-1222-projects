package pe.isil.inventorycompose.presentation

import pe.isil.inventorycompose.data.di.DataModule
import pe.isil.inventorycompose.presentation.viewmodel.ProductListViewModel

object PresentationModule {

    fun getProductListViewModel(): ProductListViewModel {
        return ProductListViewModel(DataModule.getProductRepository())
    }
}