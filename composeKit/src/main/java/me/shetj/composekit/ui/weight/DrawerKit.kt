package me.shetj.composekit.ui.weight

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults.textButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

@Composable
fun DrawerButton(
    icon: ImageVector,
    label: String,
    isSelected: Boolean,
    action: () -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = MaterialTheme.colorScheme
    val textIconColor = if (isSelected) {
        colors.primary
    } else {
        colors.onSurface.copy(alpha = 0.6f)
    }
    val backgroundColor = if (isSelected) {
        colors.primary.copy(alpha = 0.12f)
    } else {
        Color.Transparent
    }

    val surfaceModifier = modifier
        .padding(start = 8.dp, top = 8.dp, end = 8.dp)
        .fillMaxWidth()
        .height(45.dp)
    Surface(
        modifier = surfaceModifier,
        color = backgroundColor,
        shape = RoundedCornerShape(5.dp)
    ) {
        TextButton(
            onClick = action,
            modifier = Modifier
                .fillMaxWidth().fillMaxHeight(),
            shape = RoundedCornerShape(5.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().fillMaxHeight()
            ) {
                NavigationIcon(
                    icon = icon,
                    isSelected = isSelected,
                    contentDescription = null, // decorative
                    tintColor = textIconColor
                )
                Spacer(Modifier.width(16.dp))
                Text(
                    text = label,
                    style = MaterialTheme.typography.bodyMedium,
                    color = textIconColor
                )
            }
        }
    }
}

@Composable
fun NavigationIcon(
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
        modifier = modifier,
        imageVector = icon,
        contentDescription = contentDescription,
        contentScale = ContentScale.Inside,
        colorFilter = ColorFilter.tint(iconTintColor),
        alpha = imageAlpha
    )
}