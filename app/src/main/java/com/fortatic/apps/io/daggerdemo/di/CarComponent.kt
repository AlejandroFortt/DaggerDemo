package com.fortatic.apps.io.daggerdemo.di

import com.fortatic.apps.io.daggerdemo.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Es necesario anotar con @Singleton nuestro CarComponent, de
 * esta manera se hace efectiva las anotaciones @Singleton que usemos
 * en alguna de nuestras clases.
 */
@Singleton
@Component(
    modules = [
        WheelsModule::class,
        EngineModule::class
    ]
)
interface CarComponent {
    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun setModel(@SpecsQualifier(EngineSpecs.ModelEngine) modelEngine: String): Builder

        @BindsInstance
        fun setPower(@SpecsQualifier(EngineSpecs.PowerEngine) powerEngine: Int): Builder

        fun build(): CarComponent
    }
}