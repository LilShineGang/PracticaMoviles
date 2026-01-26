package ies.sequeros.dam.pmdp.aplicacion

import ies.sequeros.dam.pmdp.modelo.Digimon
import ies.sequeros.dam.pmdp.modelo.IDigimonRepositorio

class GetAllDigimonsUseCase(private val digimonRepositorio: IDigimonRepositorio) {
    suspend fun invoke():List<Digimon>{
        return digimonRepositorio.getAll()
    }
}