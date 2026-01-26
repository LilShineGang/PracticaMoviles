package ies.sequeros.dam.pmdp.infraestructura

import ies.sequeros.dam.pmdp.modelo.Digimon
import ies.sequeros.dam.pmdp.modelo.IDigimonRepositorio
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class RestDigimonRepositorio(private val url:String,private val _client: HttpClient) : IDigimonRepositorio {
    override suspend fun getAll(): List<Digimon> {
        //this._client es un objeto de la clase HttpClient con el plugin configurado
        val request = this._client.get(url)
        //obtiene el body (json), serializa y devuelve una lista de objetos
        val items: List<Digimon> = request.body()
        return items
    }
}