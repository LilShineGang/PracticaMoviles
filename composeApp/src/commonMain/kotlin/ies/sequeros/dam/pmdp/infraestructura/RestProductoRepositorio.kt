package ies.sequeros.dam.pmdp.infraestructura

import ies.sequeros.dam.pmdp.modelo.Producto
import ies.sequeros.dam.pmdp.modelo.IProductoRepositorio
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get


class RestProductoRepositorio(
    private val url:String,
    private val _client: HttpClient
) : IProductoRepositorio {

    override suspend fun getAll(): List<Producto> {
        //this._client es un objeto de la clase HttpClient con el plugin configurado
            //val request = this._client.get(url) (he comentado esto por que he pensado que aquí realmente tendría que estar un response en vez de un request.)
        //obtiene el body (json), serializa y devuelve una lista de objetos
            //val items: List<Producto> = request.body()
            //return items
        val response = this._client.get(url)
        val items: List<Producto> = response.body()

        return items
    }
}