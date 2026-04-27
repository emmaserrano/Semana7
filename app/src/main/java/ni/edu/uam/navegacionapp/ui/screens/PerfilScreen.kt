package ni.edu.uam.navegacionapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PerfilScreen(navController: NavController) {

    var likes by remember { mutableStateOf(0) }
    val maxLikes = 100

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text("Perfil", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(20.dp))

        Text("Likes: $likes ❤️")

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                if (likes < maxLikes) likes++
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Dar Like")
        }

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(
            onClick = {
                if (likes > 0) likes--
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Quitar Like")
        }

        if (likes == maxLikes) {
            Text("Llegaste al límite 😅", color = MaterialTheme.colorScheme.error)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                navController.navigate("inicio") {
                    popUpTo("inicio") { inclusive = true }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cerrar sesión")
        }
    }
}