package ies.sequeros.dam.pmdp.vista.componentes


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImagePainter
import coil3.compose.SubcomposeAsyncImage
import coil3.compose.SubcomposeAsyncImageContent
import digirest.composeapp.generated.resources.Res
import digirest.composeapp.generated.resources.img
import ies.sequeros.dam.pmdp.modelo.Producto
import org.jetbrains.compose.resources.painterResource


@Composable
fun DetalleProducto(
    item: Producto?,
    onBack: () -> Unit,
    mostrarBotonAtras: Boolean

) {
    if (item == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Selecciona un elemento")
        }
        return
    }
    Surface(
        tonalElevation = 2.dp,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement =Arrangement.Center ) {
            Text(item.nombre, style = MaterialTheme.typography.headlineSmall)
            Spacer(Modifier.height(12.dp))
            Text(item.nombre)
            Spacer(Modifier.height(16.dp))
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = "Icono producto",
                modifier = Modifier.size(100.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            if (mostrarBotonAtras) {
                Spacer(Modifier.height(16.dp))
                //Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                    Button(onClick = onBack) {
                        Text("Volver")
                    }
            }
        }
    }
}