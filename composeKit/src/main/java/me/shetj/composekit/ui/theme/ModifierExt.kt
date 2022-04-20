package me.shetj.composekit.ui.theme

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip


/**
 * [ShapeTokens] 圆角
 */
fun Modifier.cir(): Modifier {
    return this.clip(shape = CircleShape)
}


