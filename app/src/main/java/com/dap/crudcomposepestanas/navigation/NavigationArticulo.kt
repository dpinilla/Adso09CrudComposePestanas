package com.dap.crudcomposepestanas.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dap.crudcomposepestanas.view.articulo.ArticuloScreen
import com.dap.crudcomposepestanas.view.articulo.ArticuloViewModel
import com.dap.crudcomposepestanas.view.cliente.ClienteScreen
import com.dap.crudcomposepestanas.view.cliente.ClienteViewModel

@Composable
fun NavegationArticulo(
    viewModelArticulo: ArticuloViewModel
){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "articulo") {
        composable("articulo") {
            ArticuloScreen(
                /* ... */
            )
        }
        //composable<FriendsList> { FriendsListScreen( /* ... */ ) }
        // Add more destinations similarly.
    }
}