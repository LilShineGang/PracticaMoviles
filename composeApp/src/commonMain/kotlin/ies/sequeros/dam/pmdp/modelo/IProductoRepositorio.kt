package ies.sequeros.dam.pmdp.modelo

interface IProductoRepositorio {
    suspend fun getAll():List<Producto>

    suspend fun delete(id: String): Boolean

    suspend fun create(producto: Producto): Producto
}