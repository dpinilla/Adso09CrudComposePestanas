package com.dap.crudcomposepestanas.view.cliente

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun ClienteScreen(
    viewModelCliente: ClienteViewModel
){
    val lista by viewModelCliente.listaCliente.collectAsStateWithLifecycle()
    Scaffold() {MyPadding ->
        LazyColumn(Modifier
            .fillMaxSize()
            .padding(MyPadding)
        ) {

        }

    }
}