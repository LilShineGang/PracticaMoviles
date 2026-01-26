package ies.sequeros.dam.pmdp.di

import ies.sequeros.dam.pmdp.aplicacion.GetAllDigimonsUseCase
import ies.sequeros.dam.pmdp.infraestructura.RestDigimonRepositorio
import ies.sequeros.dam.pmdp.modelo.IDigimonRepositorio
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val moduloInfraestructuran = module {
    single {
         HttpClient() {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                })
            }
        }
    }

}