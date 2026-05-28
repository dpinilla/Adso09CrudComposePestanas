package com.dap.crudcomposepestanas.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dap.crudcomposepestanas.view.cliente.ClienteScreen
import com.dap.crudcomposepestanas.view.cliente.ClienteViewModel

@Composable
fun NavegationCliente(
    viewModelCliente: ClienteViewModel
){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "cliente") {
        composable("cliente") {
            ClienteScreen(
                viewModelCliente
            )
        }
        //composable<FriendsList> { FriendsListScreen( /* ... */ ) }
        // Add more destinations similarly.
    }
}