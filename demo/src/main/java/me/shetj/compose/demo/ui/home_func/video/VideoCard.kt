package me.shetj.compose.demo.ui.home_func.video

import android.view.LayoutInflater
import android.view.View
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.filled.PlaylistPlay
import androidx.compose.material.icons.filled.Replay
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.isVisible
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ui.PlayerControlView
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.ui.StyledPlayerView
import me.shetj.compose.demo.R
import okhttp3.internal.cacheGet

@Composable
fun VideoCard(videoItem: VideoItem, exoPlayer: ExoPlayer, isPlaying: Boolean, onClick: () -> Unit) {
    val isPlayerUiVisible = remember { mutableStateOf(false) }
    val isPlayButtonVisible = if (isPlayerUiVisible.value) true else !isPlaying

    Box(modifier = Modifier.fillMaxWidth().aspectRatio((16/9f))) {
        if (isPlaying) {
            VideoPlayer(exoPlayer) { uiVisible ->
                if (isPlayerUiVisible.value) {
                    isPlayerUiVisible.value = uiVisible
                } else {
                    isPlayerUiVisible.value = true
                }
            }
        } else {
            VideoThumbnail(videoItem.thumbnail)
            Icon(
                imageVector = if(isPlaying) Icons.Filled.Pause else Icons.Filled.PlayCircle,
                "播放",
                modifier = Modifier.align(Alignment.Center).size(45.dp).clickable { onClick() },
                tint = Color.White)
        }
    }
}


@Composable
fun VideoPlayer(
    exoPlayer: ExoPlayer,
    onControllerVisibilityChanged: (uiVisible: Boolean) -> Unit
) {
    val context = LocalContext.current
    val playerView = remember {
        val layout = LayoutInflater.from(context).inflate(R.layout.video_player, null, false)
        val playerView = layout.findViewById(R.id.playerView) as StyledPlayerView
        playerView.apply {
             this.setControllerVisibilityListener {
                 onControllerVisibilityChanged(it == View.VISIBLE)
             }
            player = exoPlayer
            setShowFastForwardButton(false)
            setShowNextButton(false)
            setShowPreviousButton(false)
            setShowRewindButton(false)
            setControllerOnFullScreenModeChangedListener {
                //TODO 2022/5/23 添加全屏模式
            }
        }

    }

    AndroidView({ playerView })
}