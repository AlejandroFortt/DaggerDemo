package com.fortatic.apps.io.daggerdemo

import android.util.Log
import javax.inject.Inject

interface Engine {
    fun startEngine()
}

/**
 * Anotamos el constructor con @Inject para que Dagger sepa como
 * crear instancias de esta clase
 */
class ElectricEngine @Inject constructor() :
    Engine {
    override fun startEngine() {
        Log.d("FATAL", "electric engine started")
    }
}

class DieselEngine @Inject constructor() :
    Engine {
    override fun startEngine() {
        Log.d("FATAL", "diesel engine started")
    }
}