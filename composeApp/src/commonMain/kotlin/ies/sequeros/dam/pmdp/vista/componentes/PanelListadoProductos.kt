package ies.sequeros.dam.pmdp.vista.componentes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ies.sequeros.dam.pmdp.modelo.Producto

@Composable
fun PanelListadoProductos(
    items: List<Producto>,
    selected: Producto?,
    onSelect: (Producto) -> Unit
) {
    Surface {
        if (items.isEmpty()) {
            // Mientras la petición REST carga, mostrar un aviso o carga
            Text("Cargando Productos...", modifier = Modifier.padding(16.dp))
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize()) {

                items(items, key = { it.nombre })  { item ->
                    ListItem(
                        headlineContent = {
                            Row() {
                                Icon(
                                    imageVector = Icons.Default.Pets,
                                    contentDescription = "",
                                    modifier = Modifier.size(24.dp),
                                    tint = MaterialTheme.colorScheme.primary
                                )
                                Text(item.nombre)
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {


                                onSelect(item)
                            }
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        supportingContent = {
                            Text(
                                text = "${item.precio} €",
                                maxLines = 1
                            )

                        },
                        tonalElevation = if (item.nombre == selected?.nombre) 4.dp else 0.dp
                    )
                }
            }
        }
    }
}