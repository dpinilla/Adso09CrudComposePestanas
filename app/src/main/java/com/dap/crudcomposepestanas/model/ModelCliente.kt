package com.dap.crudcomposepestanas.model

import kotlinx.serialization.Serializable


@Serializable
data class ModelCliente(
    var cedula: String? = null,
    var nombre: String? = null,
    var apellido: String? = null,
    var edad: Int? = null
)