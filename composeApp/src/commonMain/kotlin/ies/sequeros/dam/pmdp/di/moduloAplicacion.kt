package ies.sequeros.dam.pmdp.di

import ies.sequeros.dam.pmdp.aplicacion.GetAllDigimonsUseCase
import ies.sequeros.dam.pmdp.infraestructura.RestDigimonRepositorio
import ies.sequeros.dam.pmdp.modelo.IDigimonRepositorio
import org.koin.dsl.module

val moduloAplicacion = module {
    // casos de uso
    factory { GetAllDigimonsUseCase(get()) }
}