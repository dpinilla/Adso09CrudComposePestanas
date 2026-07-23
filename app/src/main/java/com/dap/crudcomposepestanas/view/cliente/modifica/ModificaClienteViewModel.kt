package com.dap.crudcomposepestanas.view.cliente.modifica

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dap.crudcomposepestanas.conexionService.ConexionCliente
import com.dap.crudcomposepestanas.model.ModelCliente
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import kotlinx.coroutines.launch

class ModificaClienteViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val cedula: String = checkNotNull(savedStateHandle["cedula"])

    fun modificarCliente(data: ModelCliente) {
        val conexionCliente = ConexionCliente()
        viewModelScope.launch {
            try {
                conexionCliente.modificarCliente(data)
            } catch (e: Exception) {
                Log.e("dap", "No se pudo conectar al backend")
            }
        }
    }

}