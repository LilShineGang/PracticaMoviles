package ies.sequeros.dam.pmdp.aplicacion

import ies.sequeros.dam.pmdp.modelo.Producto
import ies.sequeros.dam.pmdp.modelo.IProductoRepositorio

class ListarProductosUseCase(private val productoRepositorio: IProductoRepositorio) {
    suspend fun invoke():List<Producto>{
        return productoRepositorio.getAll()
    }
}