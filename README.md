# Compose Accessibility Workshop

Este proyecto demuestra cómo crear una pantalla accesible en Jetpack Compose que incluye:
- Un ícono de volver atrás 🔙.
- Una imagen con descripción.
- Un formulario con etiquetas (labels), un botón y un campo de entrada.
- Un texto que muestra la descripción y el precio de un producto.

Todos los elementos han sido configurados para ser compatibles con lectores de pantalla como TalkBack.

## **Configuración del proyecto**
1. Crea un nuevo proyecto en Android Studio:
   - Selecciona `Empty Compose Activity`.
   - Configura el nombre, el paquete y la ubicación del proyecto.
   - Activa **Kotlin** y selecciona **API mínima 21 o superior**.

2. Agrega las dependencias necesarias en `build.gradle`:
   ```groovy
   dependencies {
       implementation "androidx.activity:activity-compose:1.7.2"
       implementation "androidx.compose.ui:ui:1.5.3"
       implementation "androidx.compose.material:material:1.5.3"
       implementation "androidx.compose.ui:ui-tooling-preview:1.5.3"
       implementation "androidx.navigation:navigation-compose:2.7.3"
   }
