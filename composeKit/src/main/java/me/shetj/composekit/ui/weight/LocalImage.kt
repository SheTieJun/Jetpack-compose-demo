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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * [me.shetj.composekit.ui.preview.PreImage]
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
    height: Int = 100,
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

@Composable
fun CornerImage(
    @DrawableRes res: Int,
    modifier: Modifier,
    cornerRadius: Dp = 4.dp,
) {
    Image(
        painter = painterResource(id = res),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .clip(shape = RoundedCornerShape(cornerRadius))
    )
}
