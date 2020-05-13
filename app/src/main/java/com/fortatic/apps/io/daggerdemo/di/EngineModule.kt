package com.fortatic.apps.io.daggerdemo.di

import com.fortatic.apps.io.daggerdemo.ElectricEngine
import com.fortatic.apps.io.daggerdemo.Engine
import dagger.Module
import dagger.Provides

@Module
class EngineModule(private val model: String) {

    /**
     * Aquí le enseñamos a Dagger a crear instancias del motor que queramos usar.
     * En este caso quiero usar un ElectricEngine, pero si quisieramos que mi objeto
     * Car use un motor del tipo DieselEngine, simplemente cambiamos el parámetro del
     * método a dieselEngine: DieselEngine y devolvemos dieselEngine.
     */
    @Provides
    fun provideEngine(): Engine {
        return ElectricEngine(model)
    }
}