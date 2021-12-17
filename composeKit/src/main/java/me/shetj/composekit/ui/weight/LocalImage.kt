package me.shetj.composekit.ui.weight

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

/**
 * [me.shetj.composekit.ui.preview.PreImage.kt]
 */

@Composable
fun LocalImage(
    @DrawableRes res: Int,
    contentDescription: String? = null,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null
) {
    Image(
        painter = painterResource(id = res),
        contentDescription = contentDescription,
        modifier, alignment, contentScale, alpha, colorFilter
    )
}

@Composable
fun CirImage(
    @DrawableRes res: Int,
    width: Int = 100,
    height: Int= 100,
    borderWidth: Int = 4,
    borderColor: Color = Color.White
) {
    Image(
        painter = painterResource(id = res),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .width(width.dp)
            .height(height.dp)
            .clip(shape = RoundedCornerShape(50))
            .border(
                width = borderWidth.dp,
                color = borderColor,
                shape = RoundedCornerShape(50)
            )
    )

}

