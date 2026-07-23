package com.dap.crudcomposepestanas.conexionService

import com.dap.crudcomposepestanas.conexionService.ConexionService.Companion.url
import com.dap.crudcomposepestanas.model.ModelCliente
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.ContentType.Application.Json
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class ConexionCliente {

    val client = HttpClient{
        install(ContentNegotiation) {
            // Evita errores si el PHP manda campos extra
            json(Json { ignoreUnknownKeys = true })
        }
    }



    suspend fun consultaCliente(): List<ModelCliente> {
        return client.get("${url}consultaCliente.php").body()
    }

    suspend fun insertaCliente(data: ModelCliente): ModelCliente {
        return client.post("${url}insertaCliente.php"){
            contentType(ContentType.Application.Json)
            setBody(data)
        }
            .body()
    }

    suspend fun modificarCliente(data: ModelCliente): ModelCliente {
        return client.put("${url}modificarCliente.php"){
            contentType(ContentType.Application.Json)
            setBody(data)
        }
            .body()
    }

}