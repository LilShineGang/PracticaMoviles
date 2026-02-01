package ies.sequeros.dam.pmdp.modelo
import kotlinx.serialization.Serializable;

@Serializable
data class Producto (
    // Aqui utilizo string porque en el json el uuid viajará como texto.
    val id: String? = null,
    val nombre: String,
    val descripcion: String,
    val categoriaId: String,
    // Y aqui utilizo double en vez de big decimal porque en la parte de web no existe big decimal y no lo cogeria bien.
    val precio: Double,
    val activo: Boolean = false

) {
}