package ies.sequeros.dam.pmdp.modelo

interface IProductoRepositorio {
    suspend fun getAll():List<Producto>
}