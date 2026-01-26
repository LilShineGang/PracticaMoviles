package ies.sequeros.dam.pmdp.modelo

interface IDigimonRepositorio {
    suspend fun getAll():List<Digimon>
}