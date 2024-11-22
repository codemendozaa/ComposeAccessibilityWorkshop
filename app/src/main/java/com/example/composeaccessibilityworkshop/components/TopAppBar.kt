package com.example.composeaccessibilityworkshop.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeaccessibilityworkshop.R
import com.example.composeaccessibilityworkshop.ui.theme.ComposeAccessibilityWorkshopTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccessibilityConfigToolbar(
    title: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(start = 16.dp)
            )
        },
        actions = {
            if (checked) {
                AcsSwitch(
                    checked = checked,
                    onCheckedChange = onCheckedChange
                )
            } else {
                NonAcsSwitch(
                    checked = checked,
                    onCheckedChange = onCheckedChange
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}

@Composable
private fun AcsSwitch(checked: Boolean, onCheckedChange: ((Boolean) -> Unit)?) {
    val stateDescriptionText =
        if (checked) stringResource(id = R.string.accessibility_on_description) else stringResource(
            id = R.string.accessibility_off_description
        )
    Switch(
        modifier = Modifier.semantics {
            stateDescription = stateDescriptionText
        },
        checked = checked,
        onCheckedChange = onCheckedChange
    )
}

@Composable
private fun NonAcsSwitch(checked: Boolean, onCheckedChange: ((Boolean) -> Unit)?) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange
    )
}

@Preview(showBackground = true)
@Composable
fun AccessibilityConfigToolbarPreview() {
    ComposeAccessibilityWorkshopTheme {
        val isAccessibilityOn = remember { mutableStateOf(false) }
        AccessibilityConfigToolbar(
            title = "AccessibilityWorkshop",
            checked = isAccessibilityOn.value,
            onCheckedChange = {
                isAccessibilityOn.value = it
            })
    }
}
