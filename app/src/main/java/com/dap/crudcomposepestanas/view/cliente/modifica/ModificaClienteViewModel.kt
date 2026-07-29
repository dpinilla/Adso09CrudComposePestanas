package com.dap.crudcomposepestanas.view.cliente.modifica

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dap.crudcomposepestanas.conexionService.ConexionCliente
import com.dap.crudcomposepestanas.model.ModelCliente
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ModificaClienteViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val cedula: String = checkNotNull(savedStateHandle["cedula"])
    private val _data = MutableStateFlow<ModelCliente?>(null)
    val data : StateFlow<ModelCliente?> = _data.asStateFlow()
    val conexionCliente = ConexionCliente()

    init {
        consultarClienteId(cedula)
    }

    fun consultarClienteId(cedula: String) {
        viewModelScope.launch {
            try {
                val datos = conexionCliente.consultaClienteId(cedula)
                _data.value = datos
            } catch (e: Exception) {
                Log.e("dap", "No se pudo conectar al backend")
            }
        }
    }

    fun modificarCliente(data: ModelCliente) {

        viewModelScope.launch {
            try {
                conexionCliente.modificarCliente(data)
            } catch (e: Exception) {
                Log.e("dap", "No se pudo conectar al backend")
            }
        }
    }

}