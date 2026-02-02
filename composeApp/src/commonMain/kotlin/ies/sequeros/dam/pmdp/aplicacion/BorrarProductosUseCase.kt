package ies.sequeros.dam.pmdp.aplicacion

import ies.sequeros.dam.pmdp.modelo.IProductoRepositorio

class BorrarProductosUseCase(private val repositorio: IProductoRepositorio) {
    suspend fun invoke(id: String): Boolean {
        return repositorio.delete(id)
    }
}