package com.fortatic.apps.io.daggerdemo.di

import com.fortatic.apps.io.daggerdemo.MainActivity
import dagger.Component

@Component(modules = [WheelsModule::class])
interface CarComponent {
    fun inject(mainActivity: MainActivity)
}