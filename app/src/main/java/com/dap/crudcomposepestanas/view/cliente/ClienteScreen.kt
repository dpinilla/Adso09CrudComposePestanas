package com.dap.crudcomposepestanas.view.cliente

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dap.crudcomposepestanas.R

@Composable
fun ClienteScreen(
    viewModelCliente: ClienteViewModel
){
    val lista by viewModelCliente.listaCliente.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        viewModelCliente.visualizaCliente()
    }
    Scaffold() {MyPadding ->
        LazyColumn(Modifier
            .fillMaxSize()
            .padding(MyPadding)
        ) {
            itemsIndexed(lista){index, cliente ->
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text("${stringResource(R.string.cedula)}${cliente.cedula}")
                    Text("${stringResource(R.string.nombre)}${cliente.nombre}")
                    Text("${stringResource(R.string.apellido)}${cliente.apellido}")
                    Text("${stringResource(R.string.edad)}${cliente.edad}")
                }
            }
        }

    }
}