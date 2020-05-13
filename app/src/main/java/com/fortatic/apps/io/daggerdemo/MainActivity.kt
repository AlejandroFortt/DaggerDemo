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

    @Inject
    lateinit var car2: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Injección de campo
        val carComponent = DaggerCarComponent.builder()
            .setModel("GTX-450")
            .setPower(450)
            .build()

        carComponent.inject(this)

        /**
         * Creamos dos objetos Car para demostrar la efectividad de la anotación @Singleton
         * que usamos en la clase Drive.
         * En el logcat se puede ver como tenemos dos instancias de Car, pero estas reusan
         * una misma instancia de Drive.
         */
        car.drive()
        car2.drive()
    }
}
