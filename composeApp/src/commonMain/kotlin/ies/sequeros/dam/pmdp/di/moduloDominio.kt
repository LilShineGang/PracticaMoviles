package ies.sequeros.dam.pmdp.di

import ies.sequeros.dam.pmdp.infraestructura.RestProductoRepositorio
import ies.sequeros.dam.pmdp.modelo.IProductoRepositorio
import org.koin.dsl.module

val moduloDominio = module {
    // url para el emulador de android
    val urlApi = "http://localhost:8080/productos"
    // repositorios
    single<IProductoRepositorio> { RestProductoRepositorio(urlApi, get()) }
    //single<IProductoRepositorio> { RestProductoRepositorio("https://digimon-api.vercel.app/api/digimon",get ()) }
}