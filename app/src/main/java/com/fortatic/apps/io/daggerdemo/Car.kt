package com.fortatic.apps.io.daggerdemo

import android.util.Log
import javax.inject.Inject

class Car @Inject constructor(private val engine: Engine, private val wheels: Wheels) {
    fun drive() {
        Log.d("FATAL", "driving...")
    }

    @Inject
    fun enableRemote(remote: Remote) {
        remote.on(this)
    }
}

class Engine @Inject constructor()

class Wheels @Inject constructor()

class Remote @Inject constructor() {
    fun on(car: Car) {
        Log.d("FATAL", "control remote enable")
    }
}