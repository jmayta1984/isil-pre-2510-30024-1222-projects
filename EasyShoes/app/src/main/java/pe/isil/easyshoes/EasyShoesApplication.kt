package pe.isil.easyshoes

import android.app.Application

class EasyShoesApplication: Application() {

    companion object {
        lateinit var instance: EasyShoesApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}