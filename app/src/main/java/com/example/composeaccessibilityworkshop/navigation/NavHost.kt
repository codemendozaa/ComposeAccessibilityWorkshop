package com.example.composeaccessibilityworkshop.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

import com.example.composeaccessibilityworkshop.home.essentials.Visuals
import com.example.composeaccessibilityworkshop.home.headings.Headings
import com.example.composeaccessibilityworkshop.home.semantics.Merge
import com.example.composeaccessibilityworkshop.AppState
import com.example.composeaccessibilityworkshop.components.HomeSections


fun NavGraphBuilder.homeNavigation(appState: AppState) {
    navigation(startDestination = HomeSections.Essentials.route, route = MainDestinations.HOME) {
        composable(HomeSections.Essentials.route) {
            Visuals(isAccessibilityEnabled = appState.isAccessibilityEnabled)
        }
        composable(HomeSections.Semantics.route) {
            Merge(isAccessibilityEnabled = appState.isAccessibilityEnabled)
        }
        composable(HomeSections.Headings.route) {
            Headings(isAccessibilityEnabled = appState.isAccessibilityEnabled)
        }
    }
}