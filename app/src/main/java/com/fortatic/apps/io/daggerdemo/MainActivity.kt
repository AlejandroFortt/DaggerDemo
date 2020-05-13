package com.fortatic.apps.io.daggerdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fortatic.apps.io.daggerdemo.di.DaggerCarComponent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val car = DaggerCarComponent.create().getCar()
        car.drive()
    }
}
