package com.example.composeaccessibilityworkshop.home.headings

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.example.composeaccessibilityworkshop.components.Header
import com.example.composeaccessibilityworkshop.components.NonACSHeader
import com.example.composeaccessibilityworkshop.components.NonACSection
import com.example.composeaccessibilityworkshop.components.RowDescription
import com.example.composeaccessibilityworkshop.components.Section
import com.example.composeaccessibilityworkshop.home.semantics.AcsPostMetadata
import com.example.composeaccessibilityworkshop.home.semantics.NonAcsPostMetadata
import com.example.composeaccessibilityworkshop.home.semantics.PostMetadata
import com.example.composeaccessibilityworkshop.home.semantics.post
import com.example.composeaccessibilityworkshop.R

@Composable
fun Headings(isAccessibilityEnabled: Boolean = false) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        val metadata = remember { post }
        if (isAccessibilityEnabled) {
            AcsHeadings(metadata)
            AccessibilityBannerScreen()
        } else {
            NonAcsHeadings(metadata)
        }

    }
}

@Composable
private fun AcsHeadings(metadata: PostMetadata) {
    val loremIpsum = stringResource(id = R.string.lorem_ipsum)
    Header("Headings")
    AcsPostMetadata(metadata = metadata)
    Section("Section 1")
    RowDescription(text = loremIpsum, modifier = Modifier.padding(start = 16.dp, end = 16.dp))
    Section("Section 2")
    RowDescription(text = loremIpsum, modifier = Modifier.padding(start = 16.dp, end = 16.dp))
}


@Composable
private fun NonAcsHeadings(metadata: PostMetadata) {
    val loremIpsum = stringResource(id = R.string.lorem_ipsum2)
    NonACSHeader("Headings")
    NonAcsPostMetadata(metadata = metadata)
    NonACSection("Section 1")
    RowDescription(text = loremIpsum, modifier = Modifier.padding(start = 16.dp, end = 16.dp))
    NonACSection("Section 2")
    RowDescription(text = loremIpsum, modifier = Modifier.padding(start = 16.dp, end = 16.dp))
}

@Composable
fun AccessibilityBannerScreen() {
    val context = LocalContext.current

    // Imagen accesible con reconocimiento de creación
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .clickable {
                Toast.makeText(
                    context,
                    "Gracias por participar en Devsfest Medellín 2024 y por aprender sobre accesibilidad en mobile. ¡Esperamos que pongas en práctica lo aprendido! Esta imagen fue creada por ChatGPT.",
                    Toast.LENGTH_LONG
                ).show()
            }
            .semantics {
                contentDescription = "Banner inclusivo del evento Devsfest Medellín 2024 con mensaje de agradecimiento por aprender sobre accesibilidad en mobile. Imagen creada por ChatGPT."
            },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.minimalistic_banner), // Reemplaza con tu recurso
            contentDescription = null, // El lector de pantalla usará el texto de contentDescription en .semantics
            modifier = Modifier.fillMaxWidth(0.9f)
        )
    }
}