package com.example.composeaccessibilityworkshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.example.composeaccessibilityworkshop.components.AccessibilityConfigToolbar
import com.example.composeaccessibilityworkshop.components.AppBottomBar
import com.example.composeaccessibilityworkshop.components.HomeSections
import com.example.composeaccessibilityworkshop.navigation.MainDestinations
import com.example.composeaccessibilityworkshop.navigation.homeNavigation
import com.example.composeaccessibilityworkshop.ui.theme.ComposeAccessibilityWorkshopTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            // Update the system bars to be translucent
            val systemUiController = rememberSystemUiController()
            val useDarkIcons = MaterialTheme.colorScheme.onPrimary
            SideEffect {
                systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = true)
            }

            val appState = rememberAppState()
            ComposeAccessibilityWorkshopTheme (isAccessibilityEnabled = appState.isAccessibilityEnabled) {
                ProvideWindowInsets {
                    Surface(color = MaterialTheme.colorScheme.background) {
                        AccessibilityApp(
                            "AccessibilityWorkshop",
                            appState = appState
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun AccessibilityApp(
    name: String,
    appState: AppState = rememberAppState()
) {
    val isAccessibilityEnabled = appState.isAccessibilityEnabled
    Scaffold(
        topBar = {
            AccessibilityConfigToolbar(
                title = name,
                checked = appState.isAccessibilityEnabled,
                onCheckedChange = appState::toggleAccessibility
            )
        },
        bottomBar = {
            if (appState.shouldShowBottomBar) {
                AppBottomBar(
                    isAccessibilityEnabled = isAccessibilityEnabled,
                    currentRoute = appState.currentRoute ?: HomeSections.Essentials.route,
                    navigateToRoute = appState::navigateToBottomBarRoute
                )
            }
        }
    ) { innerPadding ->

        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = appState.navController,
            startDestination = MainDestinations.HOME
        ) {
            homeNavigation(appState = appState)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    ComposeAccessibilityWorkshopTheme  {
        AccessibilityApp(
            "AccessibilityWorkshop"
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreviewAccessibilityTheme() {
    ComposeAccessibilityWorkshopTheme (isAccessibilityEnabled = true) {
        AccessibilityApp (
            "AccessibilityWorkshop"
        )
    }
}