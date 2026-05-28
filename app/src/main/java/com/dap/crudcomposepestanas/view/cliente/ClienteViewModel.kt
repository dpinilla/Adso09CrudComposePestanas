package com.dap.crudcomposepestanas.view.cliente

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dap.crudcomposepestanas.conexionService.ConexionCliente
import com.dap.crudcomposepestanas.model.ModelCliente
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ClienteViewModel: ViewModel() {
    private val _lista = MutableStateFlow<List<ModelCliente>>(emptyList())
    val listaCliente: StateFlow<List<ModelCliente>> = _lista.asStateFlow()
    val conexionCliente = ConexionCliente()

    fun visualizaCliente(){
        viewModelScope.launch {
            try {
                val datos = conexionCliente.consultaCliente()
                _lista.value = datos
            }
            catch (e: Exception){
                Log.e("dap", "No se pudo conectar al backend")
            }
        }
    }

}