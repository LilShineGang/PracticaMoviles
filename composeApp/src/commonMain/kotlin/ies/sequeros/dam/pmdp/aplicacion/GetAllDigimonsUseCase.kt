package ies.sequeros.dam.pmdp.aplicacion

import ies.sequeros.dam.pmdp.modelo.Producto
import ies.sequeros.dam.pmdp.modelo.IDigimonRepositorio

class GetAllDigimonsUseCase(private val digimonRepositorio: IDigimonRepositorio) {
    suspend fun invoke():List<Producto>{
        return digimonRepositorio.getAll()
    }
}