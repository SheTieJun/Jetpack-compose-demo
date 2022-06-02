package me.shetj.compose.demo.ui.home.fun_mine

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.Cases
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import me.shetj.composekit.ui.theme.MD3

@Composable
fun CaseButton(name: String) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable {

            }
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(MD3.colorScheme.secondaryContainer)
                .padding(start = 15.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp),
                imageVector = Filled.Image,
                contentDescription = "contentDescription",
                contentScale = ContentScale.Inside,
                colorFilter = ColorFilter.tint(MD3.colorScheme.contentColorFor(MD3.colorScheme.secondaryContainer))
            )
            Text(
                text = name,
                style = MD3.typography.bodyMedium,
                modifier = Modifier.padding(start = 10.dp),
                color = MD3.colorScheme.contentColorFor(MD3.colorScheme.secondaryContainer)
            )
        }

    }
}

@Composable
fun CaseIcon(
    icon: ImageVector,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    tintColor: Color? = null,
) {
    val imageAlpha = if (isSelected) {
        1f
    } else {
        0.6f
    }

    val iconTintColor = tintColor ?: if (isSelected) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
    }

    Image(
        modifier = modifier
            .width(24.dp)
            .height(24.dp),
        imageVector = icon,
        contentDescription = contentDescription,
        contentScale = ContentScale.Inside,
        colorFilter = ColorFilter.tint(iconTintColor),
        alpha = imageAlpha
    )
}