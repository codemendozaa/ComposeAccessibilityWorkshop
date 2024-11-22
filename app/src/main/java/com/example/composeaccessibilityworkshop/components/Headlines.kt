package com.example.composeaccessibilityworkshop.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp

@Composable
fun Section(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text.toUpperCase(Locale.current),
        modifier = modifier
            .padding(16.dp)
            .semantics {
                heading()
            },
        style = MaterialTheme.typography.labelMedium,
    )
}


@Composable
fun NonACSection(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text.toUpperCase(Locale.current),
        modifier = modifier
            .padding(16.dp),
        style = MaterialTheme.typography.labelMedium,
    )
}

@Composable
fun Header(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.titleMedium,
) {
    Text(
        text = text,
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp)
            .semantics {
                heading()
            },
        style = style,
    )
}

@Composable
fun NonACSHeader(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.titleMedium
) {
    Text(
        text = text,
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp),
        style = style,
    )
}

@Composable
fun RowDescription(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        style = MaterialTheme.typography.bodyMedium,
        text = text
    )
}

