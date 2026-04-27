package ni.edu.uam.navegacionapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun InicioScreen(navController: NavController) {

    var nombre by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }

    fun validarNombre(input: String): Boolean {
        val limpio = input.trim()

        return when {
            limpio.isEmpty() -> {
                error = "El nombre no puede estar vacío"
                false
            }
            limpio.length < 3 -> {
                error = "Debe tener al menos 3 caracteres"
                false
            }
            !limpio.matches(Regex("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) -> {
                error = "Solo se permiten letras"
                false
            }
            else -> {
                error = ""
                true
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text("Inicio", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = nombre,
            onValueChange = {
                nombre = it
                validarNombre(it)
            },
            label = { Text("Nombre") },
            isError = error.isNotEmpty(),
            modifier = Modifier.fillMaxWidth()
        )

        if (error.isNotEmpty()) {
            Text(error, color = MaterialTheme.colorScheme.error)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                if (validarNombre(nombre)) {
                    val nombreSeguro = nombre.trim()

                    navController.navigate("detalle/$nombreSeguro") {
                        launchSingleTop = true
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Continuar")
        }
    }
}