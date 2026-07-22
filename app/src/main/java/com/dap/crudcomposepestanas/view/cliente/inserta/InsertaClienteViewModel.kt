package com.dap.crudcomposepestanas.view.cliente.inserta

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dap.crudcomposepestanas.conexionService.ConexionCliente
import com.dap.crudcomposepestanas.model.ModelCliente
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class InsertaClienteViewModel: ViewModel() {

      val conexionCliente = ConexionCliente()

    fun guardaCliente(data: ModelCliente){
        viewModelScope.launch {
            try {
                conexionCliente.insertaCliente(data)
            }
            catch (e: Exception){
                Log.e("dap", "No se pudo conectar al backend")
            }
        }
    }
}