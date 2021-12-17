
package me.shetj.composekit.ui.weight

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import me.shetj.composekit.ui.theme.compositedOnSurface

/**
 * A wrapper around [Image] and [rememberImagePainter], setting a
 * default [contentScale] and showing content while loading.
 */
@Composable
fun NetworkImage(
    url: String,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
    placeholderColor: Color? = MaterialTheme.colors.compositedOnSurface(0.2f),
    @DrawableRes drawableResId: Int ?=null
) {
    Box(modifier) {
        val painter = rememberImagePainter(
            data = url,
            builder = {
                drawableResId?.let {
                    placeholder(drawableResId = it)
                }
            }
        )

        Image(
            painter = painter,
            contentDescription = contentDescription,
            contentScale = contentScale,
            modifier = Modifier.fillMaxSize()
        )

        if (painter.state is ImagePainter.State.Loading && placeholderColor != null) {
            Spacer(
                modifier = Modifier
                    .matchParentSize()
                    .background(placeholderColor)
            )
        }
    }
}
