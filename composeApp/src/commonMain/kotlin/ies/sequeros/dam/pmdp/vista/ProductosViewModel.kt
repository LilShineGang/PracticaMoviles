package ies.sequeros.dam.pmdp.vista

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ies.sequeros.dam.pmdp.DispatcherIO
import ies.sequeros.dam.pmdp.aplicacion.BorrarProductosUseCase
import ies.sequeros.dam.pmdp.aplicacion.CrearProductoUseCase
import ies.sequeros.dam.pmdp.aplicacion.ListarProductosUseCase
import ies.sequeros.dam.pmdp.modelo.Producto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductosViewModel(
    private val listarProductosUseCase: ListarProductosUseCase,
    private val borrarProductoUseCase: BorrarProductosUseCase,
    private val crearProductoUseCase: CrearProductoUseCase
) : ViewModel() {

    private val _items = MutableStateFlow<List<Producto>>(emptyList())
    val items = _items.asStateFlow()

    init {
        // cargamos lista
        cargarProductos()
    }

    // actualizar la lista
    private fun cargarProductos() {
        viewModelScope.launch {
            try {
                withContext(DispatcherIO) {
                    val lista = listarProductosUseCase.invoke()
                    _items.value = lista
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun borrarProducto(producto: Producto) {
        viewModelScope.launch {
            withContext(DispatcherIO) {
                // Solo intentamos borrar si tiene ID (por seguridad)
                producto.id?.let { id ->
                    val exito = borrarProductoUseCase.invoke(id)
                    if (exito) {
                        //si el servidor dice que si a borrar se recarga la lista para actualizar vaya
                        cargarProductos()
                    }
                }
            }
        }
    }

    fun crearProducto(producto: Producto) {
        viewModelScope.launch {
            try {
                withContext(DispatcherIO) {
                    crearProductoUseCase.invoke(producto)
                    // si no errores -> recargar lista
                    cargarProductos()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}