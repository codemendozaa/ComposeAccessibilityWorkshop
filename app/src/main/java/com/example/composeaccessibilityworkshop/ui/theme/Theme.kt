package com.example.composeaccessibilityworkshop.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)
private val LightAccessibilityColorPalette = lightColorScheme(
    primary = Teal500,
    primaryContainer = Teal700,
    secondary = Brown200,
    secondaryContainer = Brown500
)

private val DarkAccessibilityColorPalette = darkColorScheme(
    primary = Teal200,
    primaryContainer = Teal700,
    secondary = Brown200,
    secondaryContainer = Brown500
)


@Composable
fun ComposeAccessibilityWorkshopTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    isAccessibilityEnabled: Boolean = false,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        if (isAccessibilityEnabled) {
            DarkAccessibilityColorPalette
        } else {
            DarkColorScheme
        }

    } else {
        if (isAccessibilityEnabled) {
            LightAccessibilityColorPalette
        } else {
            LightColorScheme
        }
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}


