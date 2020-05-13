package com.fortatic.apps.io.daggerdemo.di

import com.fortatic.apps.io.daggerdemo.ElectricEngine
import com.fortatic.apps.io.daggerdemo.Engine
import dagger.Binds
import dagger.Module

@Module
abstract class EngineModule {

    /**
     * Aquí le enseñamos a Dagger a crear instancias del motor que queramos usar.
     * En este caso quiero usar un ElectricEngine, pero si quisieramos que mi objeto
     * Car use un motor del tipo DieselEngine, simplemente cambiamos el parámetro del
     * método a dieselEngine: DieselEngine y devolvemos dieselEngine.
     *
     * Este modulo es un abstract class y nuestro método "proveedor" esta anotado con
     * @Binds, esto es porque Engine es una interfaz y usar @Binds en lugar de @Provides,
     * es mas eficiente.
     * Los métodos anotados con @Binds son más concisos porque se declaran como métodos
     * abstractos sin cuerpo, además Dagger no tiene que invocarlos ni crear instancias
     * de su módulo contenedor.
     *
     * @see https://medium.com/@elye.project/dagger-2-binds-vs-provides-cbf3c10511b5
     */
    @Binds
    abstract fun bindEngine(electricEngine: ElectricEngine): Engine
}