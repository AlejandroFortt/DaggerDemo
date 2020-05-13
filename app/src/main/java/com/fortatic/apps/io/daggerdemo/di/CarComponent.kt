package com.fortatic.apps.io.daggerdemo.di

import com.fortatic.apps.io.daggerdemo.MainActivity
import dagger.Component

@Component(
    modules = [
        WheelsModule::class,
        EngineModule::class
    ]
)
interface CarComponent {
    fun inject(mainActivity: MainActivity)
}