package ni.edu.uam.navegacionapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun PerfilScreen(navController: NavController) {

    var descripcion by remember { mutableStateOf(TextFieldValue("")) }
    var descripcionGuardada by remember { mutableStateOf("") }
    var editando by remember { mutableStateOf(true) }
    var error by remember { mutableStateOf("") }

    val maxCaracteres = 120
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    fun validarDescripcion(texto: String): Boolean {
        val limpio = texto.trim()

        return when {
            limpio.isEmpty() -> {
                error = "La descripción no puede estar vacía"
                false
            }
            limpio.length < 10 -> {
                error = "Debe tener al menos 10 caracteres"
                false
            }
            limpio.length > maxCaracteres -> {
                error = "Máximo $maxCaracteres caracteres"
                false
            }
            else -> {
                error = ""
                true
            }
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .padding(padding),
            verticalArrangement = Arrangement.Center
        ) {

            Text("Perfil", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(20.dp))

            // 🔄 MODO EDICIÓN
            if (editando) {

                Card(
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {

                        Text("Descripción del perfil")

                        Spacer(modifier = Modifier.height(10.dp))

                        OutlinedTextField(
                            value = descripcion,
                            onValueChange = {
                                descripcion = it
                                validarDescripcion(it.text)
                            },
                            placeholder = { Text("Escribe algo sobre ti...") },
                            isError = error.isNotEmpty(),
                            modifier = Modifier.fillMaxWidth(),
                            maxLines = 4
                        )

                        Spacer(modifier = Modifier.height(5.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("${descripcion.text.length}/$maxCaracteres")

                            if (error.isNotEmpty()) {
                                Text(
                                    error,
                                    color = MaterialTheme.colorScheme.error
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {
                        if (validarDescripcion(descripcion.text)) {
                            descripcionGuardada = descripcion.text.trim()
                            editando = false

                            scope.launch {
                                snackbarHostState.showSnackbar("Perfil guardado ✅")
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Text("Guardar perfil")
                }

            } else {
                // 👁️ MODO VISUALIZACIÓN (lo que querías)

                Card(
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {

                        Text("Tu perfil")

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(descripcionGuardada)
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                OutlinedButton(
                    onClick = {
                        editando = true
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Text("Editar perfil")
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedButton(
                onClick = {
                    navController.navigate("inicio") {
                        popUpTo("inicio") { inclusive = true }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(15.dp)
            ) {
                Text("Cerrar sesión")
            }
        }
    }
}