package ies.sequeros.dam.pmdp.di

import ies.sequeros.dam.pmdp.aplicacion.GetAllDigimonsUseCase
import ies.sequeros.dam.pmdp.infraestructura.RestDigimonRepositorio
import ies.sequeros.dam.pmdp.modelo.IDigimonRepositorio
import org.koin.dsl.module

val moduloDominio = module {
    // repositorios
    single<IDigimonRepositorio> { RestDigimonRepositorio("https://digimon-api.vercel.app/api/digimon",get ()) }
}