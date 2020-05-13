package com.fortatic.apps.io.daggerdemo.di

import com.fortatic.apps.io.daggerdemo.MainActivity
import dagger.BindsInstance
import dagger.Component

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