package com.example.composeaccessibilityworkshop.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeaccessibilityworkshop.R
import com.google.accompanist.insets.navigationBarsHeight
import com.example.composeaccessibilityworkshop.navigation.MainDestinations
import com.example.composeaccessibilityworkshop.ui.theme.ComposeAccessibilityWorkshopTheme

sealed class HomeSections(
    val route: String,
    val imageVector: ImageVector,
    @StringRes
    val resId: Int
) {
    object Essentials : HomeSections(
        "${MainDestinations.HOME}/essentials",
        Icons.Filled.Star,
        R.string.essentials_title
    )

    object Semantics : HomeSections(
        "${MainDestinations.HOME}/semantics",
        Icons.Filled.List,
        R.string.semantics_title
    )

    object Headings : HomeSections(
        "${MainDestinations.HOME}/headings",
        Icons.Filled.PlayArrow,
        R.string.headings_title
    )

    companion object {
        val values = arrayOf(Essentials, Semantics, Headings)
    }
}


@Composable
fun AppBottomBar(
    isAccessibilityEnabled: Boolean = false,
    items: Array<HomeSections> = HomeSections.values,
    currentRoute: String,
    navigateToRoute: (String) -> Unit
) {

    Column {
        if (isAccessibilityEnabled) {
            AcsAppBottomBar(
                items = items,
                currentRoute = currentRoute,
                navigateToRoute = navigateToRoute
            )
        } else {
            NonAcsAppBottomBar(
                items = items,
                currentRoute = currentRoute,
                navigateToRoute = navigateToRoute
            )
        }
        Spacer(
            Modifier
                .navigationBarsHeight()
                .fillMaxWidth()
        )
    }
}

@Composable
private fun AcsAppBottomBar(
    items: Array<HomeSections> = arrayOf(HomeSections.Essentials, HomeSections.Semantics),
    currentRoute: String,
    navigateToRoute: (String) -> Unit
) {
    val currentSelection = items.first { it.route == currentRoute }
    NavigationBar(
        tonalElevation  = 10.dp
    ) {
        items.forEach { item ->
            val selected = item == currentSelection
            NavigationBarItem(
                icon = {
                    Icon(item.imageVector, stringResource(id = item.resId))
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                    unselectedIconColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.4f)
                ),
                onClick = {
                    navigateToRoute(item.route)
                },
                selected = selected
            )
        }
    }
}

@Composable
private fun NonAcsAppBottomBar(
    items: Array<HomeSections> = arrayOf(HomeSections.Essentials, HomeSections.Semantics),
    currentRoute: String,
    navigateToRoute: (String) -> Unit
) {
    val currentSelection = items.first { it.route == currentRoute }
    NavigationBar(
        tonalElevation = 10.dp
    ) {
        items.forEach { item ->
            val selected = item == currentSelection
            NavigationBarItem(
                icon = {
                    Icon(item.imageVector, "Ir al inicio, pantalla principal de la aplicación")
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                    unselectedIconColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.4f)
                ),
                onClick = {
                    navigateToRoute(item.route)
                },
                selected = selected
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppBottomBarPreview() {
    ComposeAccessibilityWorkshopTheme {
        val selected = remember {
            mutableStateOf(HomeSections.Essentials.route)
        }
        AppBottomBar(currentRoute = selected.value, navigateToRoute = {
            selected.value = it
        })
    }
}