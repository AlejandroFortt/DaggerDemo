package com.fortatic.apps.io.daggerdemo

import android.util.Log
import javax.inject.Inject

class Car @Inject constructor(private val engine: Engine, private val wheels: Wheels) {
    fun drive() {
        engine.startEngine()
        Log.d("FATAL", "driving...")
    }

    @Inject
    fun enableRemote(remote: Remote) {
        remote.on(this)
    }
}

class Remote @Inject constructor() {
    fun on(car: Car) {
        Log.d("FATAL", "control remote enabled")
    }
}

/**
 * Supongamos que queremos que Dagger cree instancias de una clase a la cual
 * no tenemos acceso ya sea porque es una clase de una librería, o quizás es
 * propia del framework de android(p.e. String, Context, etc.).
 * En dicho caso nos es imposible agregar @Inject al constructor de dicha clase
 * ya que la clase no es modificable para nosotros.
 * La solución a esto se consigue implementando proveedores(@Provides)
 * @see package com.fortatic.apps.io.daggerdemo.di.WheelsModule
 */
class Wheels(rims: Rims, tires: Tires)

class Rims
class Tires {
    fun inflateTires() {
        Log.d("FATAL", "inflated tires")
    }
}