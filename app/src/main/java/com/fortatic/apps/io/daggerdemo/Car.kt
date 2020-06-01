package com.fortatic.apps.io.daggerdemo

import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

class Car @Inject constructor(
    private val driver: Driver,
    private val engine: Engine,
    private val wheels: Wheels
) {
    fun drive() {
        engine.startEngine()
        Timber.d("$driver is driving $this")
    }

    @Inject
    fun enableRemote(remote: Remote) {
        remote.on(this)
    }
}

class Remote @Inject constructor() {
    fun on(car: Car) {
        Timber.d("control remote enabled")
    }
}

/**
 * Al anotar esta clase con @Singleton, le decimos a Dagger que solo cree
 * una instancia de esta clase y la reuse cuando necesitemos más de una.
 *
 * Para que esta anotación funcione, también debemos anotar nuestro Component
 * (CarComponent) con @Singleton.
 */
@Singleton
class Driver @Inject constructor()

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
        Timber.d("inflated tires")
    }
}