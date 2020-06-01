package com.fortatic.apps.io.daggerdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    /**
     * Para que Dagger pueda injectar un campo, este no puede ser
     * private, ya que sería inalcanzable para DaggerCarComponent
     * @see https://dagger.dev/dev-guide/
     */
    @Inject
    lateinit var car: Car

    @Inject
    lateinit var car2: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * En cada recreación de MainActivity, solicitamos la injección de campo
         * a MainActivity mediante el método getCarComponent().
         */
        (application as MainApplication).getCarComponent().inject(this)

        /**
         * En el logcat se puede ver como tenemos dos instancias de Car, pero estas reusan
         * una misma instancia de Driver aún cuando ocurre una rotación de pantalla.
         */
        car.drive()
        car2.drive()
    }
}
