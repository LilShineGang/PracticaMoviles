package ies.sequeros.dam.pmdp.di

import ies.sequeros.dam.pmdp.aplicacion.ListarProductosUseCase
import org.koin.dsl.module

val moduloAplicacion = module {
    // casos de uso
    factory { ListarProductosUseCase(get()) }
}