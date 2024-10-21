package com.example.my30daysapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColorScheme(
    primary = Blue700,
    onPrimary = Color.White,
    secondary = Teal200,
    onSecondary = Color.Black
)

private val LightColorPalette = lightColorScheme(
    primary = Blue500,
    onPrimary = Color.White,
    secondary = Teal200,
    onSecondary = Color.Black
)

@Composable
fun My30DaysAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}