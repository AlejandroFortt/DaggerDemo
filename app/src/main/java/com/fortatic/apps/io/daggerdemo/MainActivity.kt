package com.fortatic.apps.io.daggerdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fortatic.apps.io.daggerdemo.di.DaggerCarComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    /**
     * Para que Dagger pueda injectar un campo, este no puede ser
     * private, ya que sería inalcanzable para DaggerCarComponent
     * @see https://dagger.dev/dev-guide/
     */
    @Inject
    lateinit var car: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Injección de campo
        DaggerCarComponent.create().inject(this)

        car.drive()
    }
}
