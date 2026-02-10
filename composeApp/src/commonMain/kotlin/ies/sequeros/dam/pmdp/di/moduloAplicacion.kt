package ies.sequeros.dam.pmdp.di

import ies.sequeros.dam.pmdp.aplicacion.BorrarProductosUseCase
import ies.sequeros.dam.pmdp.aplicacion.CrearProductoUseCase
import ies.sequeros.dam.pmdp.aplicacion.ListarProductosUseCase
import org.koin.dsl.module

val moduloAplicacion = module {
    // casos de uso
    factory { ListarProductosUseCase(get()) }
    factory { BorrarProductosUseCase(get()) }
    factory { CrearProductoUseCase(get()) }
}