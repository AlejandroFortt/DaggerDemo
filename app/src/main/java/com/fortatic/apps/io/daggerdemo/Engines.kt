package com.fortatic.apps.io.daggerdemo

import android.util.Log
import javax.inject.Inject

interface Engine {
    fun startEngine()
}

/**
 * Quitamos la anotación @Inject porque ahora Dagger no creará una
 * instancia de esta clase, lo haremos nosotros mediante un método
 * proveedor en EngineModule.
 */
class ElectricEngine (private val model: String) :
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