package ni.edu.uam.navegacionapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import ni.edu.uam.navegacionapp.ui.screens.*

@Composable
fun NavManager() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "inicio"
    ) {

        composable("inicio") {
            InicioScreen(navController)
        }

        composable("detalle/{nombre}") { backStackEntry ->
            val nombre = backStackEntry.arguments?.getString("nombre") ?: ""
            DetalleScreen(navController, nombre)
        }

        composable("perfil") {
            PerfilScreen(navController)
        }
    }
}