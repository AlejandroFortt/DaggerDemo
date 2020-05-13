package com.fortatic.apps.io.daggerdemo

import android.util.Log
import javax.inject.Inject
import javax.inject.Named

interface Engine {
    fun startEngine()
}

/**
 * Agregamos la anotación @Inject porque ahora Dagger creará una
 * instancia de esta clase, nosotros proveeremos el @param model
 * CarComponent.
 */
class ElectricEngine @Inject constructor(
    @Named("model engine") private val model: String
) :
    Engine {
    override fun startEngine() {
        Log.d("FATAL", "electric engine: $model started")
    }
}

class DieselEngine @Inject constructor() :
    Engine {
    override fun startEngine() {
        Log.d("FATAL", "diesel engine started")
    }
}