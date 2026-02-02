package ies.sequeros.dam.pmdp.aplicacion

import ies.sequeros.dam.pmdp.modelo.IProductoRepositorio
import ies.sequeros.dam.pmdp.modelo.Producto

class CrearProductoUseCase(private val repositorio: IProductoRepositorio) {
    suspend fun invoke(producto: Producto): Producto {
        return repositorio.create(producto)
    }
}