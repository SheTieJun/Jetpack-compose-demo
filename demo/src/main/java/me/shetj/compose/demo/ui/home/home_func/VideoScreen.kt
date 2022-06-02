package me.shetj.compose.demo.ui.home.home_func

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import me.shetj.compose.demo.ui.home.home_func.video.VideoCard
import me.shetj.compose.demo.ui.home.home_func.video.VideoItem
import me.shetj.compose.demo.ui.home.home_weight.DemoTopBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VideoScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val exoPlayer = remember(context) { ExoPlayer.Builder(context).build() }

    val videos  =  remember { mutableListOf<VideoItem>().apply {
        repeat(10){
            add(VideoItem.mock(it))
        }
    } }

    var playingItemIndex  by remember { mutableStateOf(0) }
    Scaffold(modifier = modifier,
        topBar = {
            DemoTopBar("Video ExoPlay Sample")
        }) {
        LazyColumn {
            itemsIndexed(items = videos, key = { _, video -> video.id }) { index, video ->
                VideoCard(
                    videoItem = video,
                    exoPlayer = exoPlayer,
                    isPlaying = index == playingItemIndex,
                    onClick = {
                        playingItemIndex = index
                    }
                )
            }
        }
    }

    LaunchedEffect(playingItemIndex) {
        Log.i("LaunchedEffect","$playingItemIndex")
        if (playingItemIndex == null || playingItemIndex >videos.size ) {
            exoPlayer.pause()
        } else {
            val video = videos[playingItemIndex]
            exoPlayer.setMediaItem(MediaItem.fromUri(video.mediaUrl), video.lastPlayedPosition)
            exoPlayer.prepare()
            exoPlayer.playWhenReady = true
        }
    }



    DisposableEffect(exoPlayer) {
        val lifecycleObserver = LifecycleEventObserver { _, event ->
            if (playingItemIndex == null) return@LifecycleEventObserver
            when (event) {
                Lifecycle.Event.ON_START -> exoPlayer.play()
                Lifecycle.Event.ON_STOP -> exoPlayer.pause()
            }
        }

        lifecycleOwner.lifecycle.addObserver(lifecycleObserver)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(lifecycleObserver)
            exoPlayer.release()
        }
    }

}

