# Compose Accessibility Workshop

# DevFest Medellín 2024 - Inclusión y Accesibilidad en Mobile

¡Bienvenidos al **DevFest Medellín 2024**! Este repositorio es parte del taller dedicado a **accesibilidad en aplicaciones móviles**, donde aprenderás las mejores prácticas y técnicas esenciales para crear aplicaciones inclusivas.

---

## Captura de Pantalla

<div align="center">
  <img src="demo.png" alt="Demo mostrando accesibilidad en aplicaciones móviles" width="300" />
</div>

> **Nota:** Esta imagen fue creada por ChatGPT y representa la importancia de la inclusión en tecnología.

---

## ¿Qué aprenderás?

- Principios de accesibilidad.
- Implementación de componentes accesibles en Jetpack Compose.
- Mejores prácticas para un diseño inclusivo.

---

## Cómo empezar

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu_usuario/tu_repositorio.git

## **Configuración del proyecto**
1. Crea un nuevo proyecto en Android Studio:
   - Selecciona `Empty Compose Activity`.
   - Configura el nombre, el paquete y la ubicación del proyecto.
   - Activa **Kotlin** y selecciona **API mínima 21 o superior**.

2. Agrega las dependencias necesarias en `build.gradle`:
   ```groovy
   implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)



    implementation(libs.androidx.navigation.compose)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    implementation(libs.accompanist.insets)
    implementation(libs.accompanist.systemuicontroller)
```

navigationCompose = "2.8.4"
material3 = "2.1.0"
ui = "1.1.0"
ui-graphics = "1.1.0"
accompanist = "0.30.1"
material = "1.12.0"

androidx-core-ktx = { group = "androidx.core", name = "core-ktx", version.ref = "coreKtx" }
junit = { group = "junit", name = "junit", version.ref = "junit" }
androidx-junit = { group = "androidx.test.ext", name = "junit", version.ref = "junitVersion" }
androidx-espresso-core = { group = "androidx.test.espresso", name = "espresso-core", version.ref = "espressoCore" }
androidx-lifecycle-runtime-ktx = { group = "androidx.lifecycle", name = "lifecycle-runtime-ktx", version.ref = "lifecycleRuntimeKtx" }
androidx-activity-compose = { group = "androidx.activity", name = "activity-compose", version.ref = "activityCompose" }
androidx-compose-bom = { group = "androidx.compose", name = "compose-bom", version.ref = "composeBom" }
androidx-ui = { group = "androidx.compose.ui", name = "ui" }
androidx-ui-graphics = { group = "androidx.compose.ui", name = "ui-graphics" }
androidx-ui-tooling = { group = "androidx.compose.ui", name = "ui-tooling" }
androidx-ui-tooling-preview = { group = "androidx.compose.ui", name = "ui-tooling-preview" }
androidx-ui-test-manifest = { group = "androidx.compose.ui", name = "ui-test-manifest" }
androidx-ui-test-junit4 = { group = "androidx.compose.ui", name = "ui-test-junit4" }
androidx-material3 = { group = "androidx.compose.material3", name = "material3" }
androidx-navigation-compose = { group = "androidx.navigation", name = "navigation-compose", version.ref = "navigationCompose" }
accompanist-insets = { group = "com.google.accompanist", name = "accompanist-insets", version.ref = "accompanist" }
accompanist-systemuicontroller = { group = "com.google.accompanist", name = "accompanist-systemuicontroller", version.ref = "accompanist" }
material = { group = "com.google.android.material", name = "material", version.ref = "material" }
```

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
