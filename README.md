# Semana7
# 📱 NavegacionApp

Aplicación móvil desarrollada en Android con **Kotlin** y **Jetpack Compose**, que implementa un sistema de navegación entre múltiples pantallas, validaciones de entrada y una interfaz moderna e interactiva.

---

## 🎯 Objetivo del proyecto

Desarrollar una aplicación que permita comprender el flujo de navegación entre pantallas en Android, aplicando buenas prácticas de desarrollo, validaciones y experiencia de usuario.

---

## 🧩 Funcionalidades principales

* ✅ Navegación entre 3 pantallas:

    * Inicio
    * Detalle
    * Perfil

* ✅ Paso de datos entre pantallas (nombre del usuario)

* ✅ Validaciones en formularios:

    * Campo obligatorio
    * Mínimo de caracteres
    * Restricción de solo letras

* ✅ Pantalla de perfil interactiva:

    * Edición de descripción
    * Validación de texto
    * Contador de caracteres
    * Modo visualización tras guardar
    * Opción de editar nuevamente

* ✅ Retroalimentación al usuario:

    * Mensajes de error
    * Snackbar de confirmación

---

## 🧭 Flujo de navegación

Inicio → Detalle → Perfil → Inicio

* El usuario ingresa su nombre en la pantalla de inicio
* Se muestra un saludo personalizado en la pantalla de detalle
* En la pantalla de perfil puede crear y guardar su descripción
* Puede volver al inicio cerrando sesión

---

## 🛠️ Tecnologías utilizadas

* Kotlin
* Jetpack Compose
* Navigation Compose
* Material 3

---

## 📂 Estructura del proyecto

```
navigation/
   NavManager.kt

ui/screens/
   InicioScreen.kt
   DetalleScreen.kt
   PerfilScreen.kt

MainActivity.kt
```

---

## 🔐 Validaciones implementadas

### Pantalla Inicio

* Campo nombre obligatorio
* Mínimo 3 caracteres
* Solo letras permitidas
* Eliminación de espacios innecesarios

### Pantalla Perfil

* Descripción obligatoria
* Mínimo 10 caracteres
* Máximo 120 caracteres
* Mensajes de error dinámicos

---

## 🚀 Instrucciones de ejecución

1. Clonar el repositorio:

```
git clone https://github.com/TU-USUARIO/NavegacionApp.git
```

2. Abrir el proyecto en **Android Studio**

3. Esperar a que se sincronicen las dependencias

4. Ejecutar la aplicación en:

    * Emulador Android
    * Dispositivo físico

---

## 📌 Requisitos

* Android Studio instalado
* SDK mínimo: API 24
* Conexión a internet (para dependencias)


---

## 🧪 Estado del proyecto

✔ Funcional
✔ Navegación completa
✔ Validaciones implementadas
✔ Interfaz moderna

---


