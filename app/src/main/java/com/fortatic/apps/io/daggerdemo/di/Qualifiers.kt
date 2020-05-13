package com.fortatic.apps.io.daggerdemo.di

import javax.inject.Qualifier

/**
 * Aquí declaramos nuestras anotaciones personalizadas, antes usabamos @Named
 * para poder injectar las dos especificaciones necesarias para que Dagger sepa
 * como crear una instancia de Engine.
 * Reemplazamos @Named porque era propenso a errores ya que usabamos un valor
 * escrito por nosotros mismos, aquí con @SpecsQuialifier usamos un enum class para
 * evitar dichos errores.
 *
 * Con @Named:
 *  @Named("model engine") -> Propenso a errores de tipeo.
 *
 * Con @SpecsQuialifier:
 *  @SpecsQuialifier(EngineSpecs.ModelEngine) -> no hay posibilidad de errores.
 */

@Qualifier
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class SpecsQualifier(val spec: EngineSpecs)

enum class EngineSpecs {
    PowerEngine, ModelEngine
}