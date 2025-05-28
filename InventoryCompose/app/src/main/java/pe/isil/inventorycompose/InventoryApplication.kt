package pe.isil.inventorycompose

import android.app.Application

class InventoryApplication: Application() {

    companion object {
        lateinit var instance: InventoryApplication
    }

    override fun onCreate() {
        instance = this
        super.onCreate()
    }
}