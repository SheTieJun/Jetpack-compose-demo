package me.shetj.composekit.ui.theme

import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import androidx.annotation.RequiresApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import me.shetj.composekit.R

@Composable
fun DynamicTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        if (VERSION.SDK_INT >= VERSION_CODES.S) {
            dynamicDarkColorScheme(LocalContext.current)
        } else {
            darkColorScheme()
        }
    } else {
        if (VERSION.SDK_INT >= VERSION_CODES.S) {
            dynamicLightColorScheme(LocalContext.current)
        } else {
            lightColorScheme()
        }
    }
    BaseTheme(darkTheme, colors, content)
}


private val GreenThemeLight = lightColorScheme(
    primary = Green40,
    primaryContainer = Green90,
    onPrimary = Green100,
    onPrimaryContainer = Green10,
)

private val GreenThemeDark = darkColorScheme(
    primary = Green80,
    primaryContainer = Green30,
    onPrimary = Green20,
    onPrimaryContainer = Green90,
)

@Composable
fun GreenTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        GreenThemeDark
    } else {
        GreenThemeLight
    }
    BaseTheme(darkTheme, colors, content)
}


private val YellowThemeLight = lightColorScheme(
    primary = Yellow40,
    primaryContainer = Yellow90,
    onPrimary = Yellow100,
    onPrimaryContainer = Yellow10,
)

private val YellowThemeDark = darkColorScheme(
    primary = Yellow80,
    primaryContainer = Yellow30,
    onPrimary = Yellow20,
    onPrimaryContainer = Yellow90,
)

@Composable
fun YellowTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        YellowThemeDark
    } else {
        YellowThemeLight
    }
    BaseTheme(darkTheme, colors, content)
}

private val BlueThemeLight = lightColorScheme(
    primary = Blue40,
    primaryContainer = Blue90,
    onPrimary = Blue100,
    onPrimaryContainer = Blue10,
)

private val BlueThemeDark = darkColorScheme(
    primary = Blue80,
    primaryContainer = Blue30,
    onPrimary = Blue20,
    onPrimaryContainer = Blue90,
)

@Composable
fun BlueTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        BlueThemeDark
    } else {
        BlueThemeLight
    }
    BaseTheme(darkTheme, colors, content)
}

private val RedThemeLight = lightColorScheme(
    primary = Red40,
    primaryContainer = Red90,
    onPrimary = Red100,
    onPrimaryContainer = Blue10,
)

private val RedThemeDark = darkColorScheme(
    primary = Red80,
    primaryContainer = Red30,
    onPrimary = Red20,
    onPrimaryContainer = Red90,
)

@Composable
fun RedTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        RedThemeDark
    } else {
        RedThemeLight
    }
    BaseTheme(darkTheme, colors, content)
}

private val LightElevation = Elevations()

private val DarkElevation = Elevations(card = 1.dp)

private val LightImages = Images(lockupLogo = R.drawable.ic_launcher_background)

private val DarkImages = Images(lockupLogo = R.drawable.ic_launcher_background)

@Composable
private fun BaseTheme(
    darkTheme: Boolean,
    colors: ColorScheme,
    content: @Composable () -> Unit
) {
    val elevation = if (darkTheme) DarkElevation else LightElevation
    val images = if (darkTheme) DarkImages else LightImages
    CompositionLocalProvider(
        LocalElevations provides elevation,
        LocalImages provides images
    ) {
        MaterialTheme(
            colorScheme = colors,
            content = content
        )
    }
}

