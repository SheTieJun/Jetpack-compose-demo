package me.shetj.compose.demo.ui.home_func.video

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import me.shetj.composekit.ui.weight.NetworkImage

@Composable
fun VideoThumbnail(url: String) {
    NetworkImage(url,
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(16/9f),
        contentScale = ContentScale.Crop
    )
}