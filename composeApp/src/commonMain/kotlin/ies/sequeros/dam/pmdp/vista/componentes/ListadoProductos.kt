package ies.sequeros.dam.pmdp.vista.componentes

import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffold
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.layout.calculatePaneScaffoldDirective
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import ies.sequeros.dam.pmdp.modelo.Producto
import ies.sequeros.dam.pmdp.vista.ProductosViewModel
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun ListadoProductos() {
    val vm: ProductosViewModel = koinViewModel()
    val navigator = rememberListDetailPaneScaffoldNavigator<Nothing>()
    val scope = rememberCoroutineScope()

    var selectedItem by remember { mutableStateOf<Producto?>(null) }

    var mostrarFormulario by remember { mutableStateOf(false) }

    val items = vm.items.collectAsState()

    fun onSelect(item: Producto) {
        selectedItem = item
        scope.launch {
            navigator.navigateTo(ListDetailPaneScaffoldRole.Detail)
        }
    }

    val windowInfo = currentWindowAdaptiveInfo()
    val directive = calculatePaneScaffoldDirective(windowInfo)
    val mostrarBotonAtras = directive.maxHorizontalPartitions == 1

    if (mostrarFormulario) {
        FormularioProducto(
            onDismiss = { mostrarFormulario = false },
            onSave = { nuevoProducto ->
                vm.crearProducto(nuevoProducto)
                mostrarFormulario = false
            }
        )
    }

    ListDetailPaneScaffold(
        directive = navigator.scaffoldDirective,
        value = navigator.scaffoldValue,
        listPane = {
            PanelListadoProductos(
                items = items.value,
                selected = selectedItem,
                onSelect = ::onSelect,
                onDelete = { vm.borrarProducto(it) },
                onCreate = { mostrarFormulario = true }
            )
        },
        detailPane = {
            DetalleProducto(
                item = selectedItem,
                onBack = {
                    scope.launch {
                        navigator.navigateBack()
                    }
                },
                mostrarBotonAtras = mostrarBotonAtras
            )
        },
    )
}