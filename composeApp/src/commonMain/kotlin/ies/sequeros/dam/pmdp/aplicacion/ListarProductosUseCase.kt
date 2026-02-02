package ies.sequeros.dam.pmdp.aplicacion

import ies.sequeros.dam.pmdp.modelo.Producto
import ies.sequeros.dam.pmdp.modelo.IProductoRepositorio

class ListarProductosUseCase(private val digimonRepositorio: IProductoRepositorio) {
    suspend fun invoke():List<Producto>{
        return repositorio.getAll()
    }
}