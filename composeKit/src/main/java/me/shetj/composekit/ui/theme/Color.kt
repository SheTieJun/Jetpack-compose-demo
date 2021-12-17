package me.shetj.composekit.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver

/**
 * [androidx.compose.material3.tokens.Palette]
 */

val Green10 = Color(red = 7, green = 39, blue = 17)
val Green100 = Color(red = 255, green = 255, blue = 255)
val Green20 = Color(red = 10, green = 56, blue = 24)
val Green30 = Color(red = 15, green = 82, blue = 35)
val Green40 = Color(red = 20, green = 108, blue = 46)
val Green50 = Color(red = 25, green = 134, blue = 57)
val Green80 = Color(red = 109, green = 213, blue = 140)
val Green90 = Color(red = 196, green = 238, blue = 208)


val Blue10 = Color(red = 4, green = 30, blue = 73)
val Blue100 = Color(red = 255, green = 255, blue = 255)
val Blue20 = Color(red = 6, green = 46, blue = 111)
val Blue30 = Color(red = 8, green = 66, blue = 160)
val Blue40 = Color(red = 11, green = 87, blue = 208)
val Blue80 = Color(red = 168, green = 199, blue = 250)
val Blue90 = Color(red = 211, green = 227, blue = 253)


val Yellow10 = Color(red = 66, green = 31, blue = 0)
val Yellow100 = Color(red = 255, green = 255, blue = 255)
val Yellow20 = Color(red = 86, green = 45, blue = 0)
val Yellow30 = Color(red = 117, green = 66, blue = 0)
val Yellow40 = Color(red = 148, green = 87, blue = 0)
val Yellow80 = Color(red = 255, green = 187, blue = 41)
val Yellow90 = Color(red = 255, green = 223, blue = 153)

val Red100 = Color(red = 255, green = 255, blue = 255)
val Red20 = Color(red = 96, green = 20, blue = 16)
val Red30 = Color(red = 140, green = 29, blue = 24)
val Red40 = Color(red = 179, green = 38, blue = 30)
val Red80 = Color(red = 242, green = 184, blue = 181)
val Red90 = Color(red = 249, green = 222, blue = 220)

@Composable
fun Colors.compositedOnSurface(alpha: Float): Color {
    return onSurface.copy(alpha = alpha).compositeOver(surface)
}