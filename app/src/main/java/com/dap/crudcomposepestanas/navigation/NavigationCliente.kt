package com.dap.crudcomposepestanas.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dap.crudcomposepestanas.view.cliente.ClienteScreen
import com.dap.crudcomposepestanas.view.cliente.ClienteViewModel
import com.dap.crudcomposepestanas.view.cliente.inserta.InsertaClienteScreen
import com.dap.crudcomposepestanas.view.cliente.modifica.ModificaClienteScreen

@Composable
fun NavegationCliente(
    viewModelCliente: ClienteViewModel
){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "cliente") {
        composable("cliente") {
            ClienteScreen(
                viewModelCliente,
                onGoInsertar = {navController.navigate("insertaCliente")}
            )
        }
        composable("insertaCliente") {
            InsertaClienteScreen(
                onGoCerrar = { navController.popBackStack()}
            )
        }

        composable(
            "modificaCliente/{cedula}",
            listOf(navArgument("cedula"){type = NavType.StringType})
        ) {
            ModificaClienteScreen(
                //onGoCerrar = { navController.popBackStack()}
            )
        }

        //composable<FriendsList> { FriendsListScreen( /* ... */ ) }
        // Add more destinations similarly.
    }
}