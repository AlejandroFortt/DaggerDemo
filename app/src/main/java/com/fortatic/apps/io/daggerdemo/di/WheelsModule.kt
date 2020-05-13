package com.fortatic.apps.io.daggerdemo.di

import com.fortatic.apps.io.daggerdemo.Rims
import com.fortatic.apps.io.daggerdemo.Tires
import com.fortatic.apps.io.daggerdemo.Wheels
import dagger.Module
import dagger.Provides

@Module
object WheelsModule {

    /**
     * Aquí le enseñamos a Dagger a crear instancias del tipo Rims.
     */
    @Provides
    fun provideRims() = Rims()

    /**
     * Aquí le enseñamos a Dagger a crear instancias del tipo Tires.
     */
    @Provides
    fun provideTires(): Tires {
        val tires = Tires()
        tires.inflateTires()
        return tires
    }

    /**
     * Aquí le enseñamos a Dagger a crear instancias del tipo Wheels.
     *
     * En este punto Dagger ya sabe cómo crear instancias de tipo Rims y Tires, pues
     * lo aprendió con los métodos provideRims() y provideTires() por lo que simplemente
     * pasamos rims y tires como parámetros al metodo provideWheels y este nos devuelve
     * una instancia de Wheels ya construido.
     */
    @Provides
    fun provideWheels(rims: Rims, tires: Tires) = Wheels(rims, tires)
}