/*
 * MIT License
 *
 * Copyright (c) 2019 SheTieJun
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package me.shetj.composekit.ui.theme

import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import androidx.compose.foundation.ExperimentalFoundationApi
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

    val dynamicColor = VERSION.SDK_INT >= VERSION_CODES.S
    val colorScheme = when {
        dynamicColor && darkTheme -> dynamicDarkColorScheme(LocalContext.current)
        dynamicColor && !darkTheme -> dynamicLightColorScheme(LocalContext.current)
        darkTheme -> darkColorScheme()
        else -> lightColorScheme()
    }
    BaseTheme(darkTheme, colorScheme, content)
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
    onPrimaryContainer = Red30,
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
fun DefTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    DynamicTheme(darkTheme,content)
}


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


//      LocalOverScrollConfiguration provides null, // == android:overScrollMode="never"