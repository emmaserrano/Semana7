package ni.edu.uam.navegacionapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DetalleScreen(navController: NavController, nombre: String) {

    val nombreSeguro = nombre.ifBlank { "Usuario" }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text("Detalle", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(20.dp))

        Text("Hola, $nombreSeguro ")

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                navController.navigate("perfil") {
                    launchSingleTop = true
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ir a Perfil")
        }

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver")
        }
    }
}