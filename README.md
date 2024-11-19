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

3.## Crear la UI con elementos accesibles

En el archivo `MainActivity.kt`, diseña la pantalla principal con los siguientes componentes accesibles:

- **Icono de volver atrás.**  
- **Imagen con descripción.**  
- **Texto con la descripción y el precio del producto.**  
- **Formulario con un campo de entrada y un botón.**

Aquí tienes un ejemplo de código para los elementos accesibles:

```kotlin
@Composable
fun AccessibleScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Icono de volver atrás
        IconButton(
            onClick = { /* Acción para regresar */ },
            modifier = Modifier.semantics {
                contentDescription = "Volver atrás"
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_back), 
                contentDescription = "Volver atrás"
            )
        }

        // Imagen con descripción
        Image(
            painter = painterResource(id = R.drawable.ic_product_image), 
            contentDescription = "Imagen del producto", 
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        // Título y descripción del producto
        Text(
            text = "Producto de Ejemplo",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.semantics { contentDescription = "Título del producto" }
        )
        Text(
            text = "Este es un producto de ejemplo. Precio: $19.99",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.semantics { contentDescription = "Descripción y precio del producto" }
        )

        // Formulario con etiquetas y botón
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Nombre:", modifier = Modifier.semantics { contentDescription = "Campo para nombre" })
            BasicTextField(
                value = TextFieldValue(),
                onValueChange = { /* actualizar valor */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(Color.Gray),
                decorationBox = { innerTextField ->
                    Box(modifier = Modifier.padding(8.dp)) {
                        innerTextField()
                    }
                }
            )

            Button(
                onClick = { /* Acción al presionar botón */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .semantics { contentDescription = "Botón de acción" }
            ) {
                Text("Enviar")
            }
        }
    }
}
```

## 4. Configuración para accesibilidad

Asegúrate de que todos los elementos de la UI tengan configuraciones de accesibilidad:

- **Uso de `contentDescription`:**  
  Todos los elementos que no son texto (como íconos e imágenes) deben tener un `contentDescription` adecuado.

- **Uso de `semantics`:**  
  Esto asegura que los elementos sean accesibles para los lectores de pantalla.

- **Etiquetas (`labels`):**  
  Los campos de entrada deben tener etiquetas claras, como "Nombre", para facilitar la comprensión de la interfaz.

## 5. Pruebas de accesibilidad

Para probar la accesibilidad de tu aplicación, habilita TalkBack en un dispositivo Android o usa un emulador:

- Ve a **Configuración > Accesibilidad > TalkBack**.
- Activa **TalkBack** y navega por tu aplicación para asegurarte de que los elementos sean correctamente leídos y sean fáciles de interactuar.
