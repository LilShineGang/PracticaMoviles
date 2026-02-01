package ies.sequeros.dam.pmdp.vista

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ies.sequeros.dam.pmdp.DispatcherIO
import ies.sequeros.dam.pmdp.aplicacion.GetAllDigimonsUseCase

import ies.sequeros.dam.pmdp.modelo.Producto

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DigimonViewModel(getAllDigimonUseCase: GetAllDigimonsUseCase) : ViewModel() {
    private val _items = MutableStateFlow<List<Producto>>(emptyList())

    val items = _items.asStateFlow()

    init {
        viewModelScope.launch {
            withContext(DispatcherIO) {
                _items.value = getAllDigimonUseCase.invoke()
            }
        }

    }
}