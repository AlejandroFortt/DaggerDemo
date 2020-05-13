package com.fortatic.apps.io.daggerdemo.di

import com.fortatic.apps.io.daggerdemo.Car
import dagger.Component

@Component
interface CarComponent {
    fun getCar() : Car
}