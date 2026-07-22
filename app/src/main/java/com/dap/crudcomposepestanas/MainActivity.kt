package com.dap.crudcomposepestanas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import com.dap.crudcomposepestanas.navigation.NavegationArticulo
import com.dap.crudcomposepestanas.navigation.NavegationCliente
import com.dap.crudcomposepestanas.ui.theme.CrudComposePestanasTheme
import com.dap.crudcomposepestanas.view.articulo.ArticuloViewModel
import com.dap.crudcomposepestanas.view.cliente.ClienteViewModel

class MainActivity : ComponentActivity() {
    val viewModelCliente: ClienteViewModel by viewModels()
    val viewModelArticulo: ArticuloViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CrudComposePestanasTheme {
                NavegationCliente(viewModelCliente)
                //CrudComposePestanasApp(viewModelCliente, viewModelArticulo)
            }
        }
    }
}


@Composable
fun CrudComposePestanasApp(
    viewModelCliente: ClienteViewModel,
    viewModelArticulo: ArticuloViewModel
) {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.CLIENTE) }

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestinations.entries.forEach {
                item(
                    icon = {
                        Icon(
                            it.icon,
                            contentDescription = it.label
                        )
                    },
                    label = { Text(it.label) },
                    selected = it == currentDestination,
                    onClick = { currentDestination = it }
                )
            }
        }
    ) {
        when(currentDestination){
            AppDestinations.CLIENTE-> NavegationCliente(viewModelCliente)
            AppDestinations.ARTICULO-> NavegationArticulo(viewModelArticulo)
        }
    }
}

enum class AppDestinations(
    val label: String,
    val icon: ImageVector,
) {
    CLIENTE("Cliente", Icons.Default.Face),
    ARTICULO("Artículos", Icons.Default.Favorite),
}

