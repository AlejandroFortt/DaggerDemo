package com.fortatic.apps.io.daggerdemo.di

import com.fortatic.apps.io.daggerdemo.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

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
        fun setModel(@Named("model engine") model: String): Builder

        fun build(): CarComponent
    }
}