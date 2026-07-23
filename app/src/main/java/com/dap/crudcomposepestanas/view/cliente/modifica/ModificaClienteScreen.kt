package com.dap.crudcomposepestanas.view.cliente.modifica

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dap.crudcomposepestanas.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModificaClienteScreen(){
    var cedula by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    val modificaClienteViewModel: ModificaClienteViewModel = viewModel()
    val data by modificaClienteViewModel

    LaunchedEffect(data) {

    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        stringResource(R.string.modificar),
                        Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            )
        }
    ) {myPadding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(myPadding)
        ) {
            TextField(
                value = cedula,
                onValueChange = { cedula = it},
                Modifier.fillMaxWidth(),
                label = {Text(stringResource(R.string.cedula))}
            )
            Spacer(Modifier.height(30.dp)
            )
            TextField(
                value = nombre,
                onValueChange = { nombre = it},
                Modifier.fillMaxWidth(),
                label = {Text(stringResource(R.string.nombre))}
            )
            Spacer(Modifier.height(30.dp)
            )
            TextField(
                value = apellido,
                onValueChange = { apellido = it},
                Modifier.fillMaxWidth(),
                label = {Text(stringResource(R.string.apellido))}
            )
            Spacer(Modifier.height(30.dp)
            )
            TextField(
                value = edad,
                onValueChange = { edad = it},
                Modifier.fillMaxWidth(),
                label = {Text(stringResource(R.string.edad))}
            )
            Spacer(Modifier.height(30.dp)
            )
        }

    }
}