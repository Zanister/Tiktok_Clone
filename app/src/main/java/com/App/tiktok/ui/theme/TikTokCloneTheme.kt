package com.App.tiktok.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Define your color palette
private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFFF2D55), // TikTok red color
    onPrimary = Color.White,
    secondary = Color(0xFF1D1D1D), // Secondary color
    onSecondary = Color.White,
    background = Color(0xFFFFFFFF), // Background color
    onBackground = Color(0xFF000000), // On background color
    surface = Color(0xFFFFFFFF), // Surface color
    onSurface = Color(0xFF000000) // On surface color
)

@Composable
fun TikTokCloneTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        shapes = Shapes, // You can define Shapes separately
        content = content
    )
}

// Optionally, define Typography and Shapes

private val Shapes = androidx.compose.material3.Shapes()
