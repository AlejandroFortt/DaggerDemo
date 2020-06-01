package com.fortatic.apps.io.daggerdemo

import android.app.Application
import com.fortatic.apps.io.daggerdemo.di.CarComponent
import com.fortatic.apps.io.daggerdemo.di.DaggerCarComponent
import timber.log.Timber

class MainApplication : Application() {

    /**
     * Movemos aquí la injección de campo que haciamos en MainActivity,
     * esto para que @Singleton nos entregue un único objeto aún cuando
     * ocurran cambios de configuración como por ejemplo una rotación
     * de pantalla.
     * MainApplication se crea una única vez durante la vida de la aplicación,
     * por lo tanto es la indicada para proporcionarnos injecciones unicas
     * como las anotadas con @Singleton.
     */
    private val component: CarComponent by lazy {
        DaggerCarComponent.builder()
            .setModel("MTG-550")
            .setPower(550)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Tree())
        }
    }

    fun getCarComponent() = component
}

class Tree() : Timber.DebugTree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        super.log(priority, "$tag FATAL", message, t)
    }
}