package me.shetj.compose.demo.ui.home.home_func.video

import androidx.compose.runtime.Immutable

@Immutable
data class VideoItem(
    val id: Int,
    val mediaUrl: String,
    val thumbnail: String,
    val lastPlayedPosition: Long = 0
) {
    companion object {
        fun mock(position: Int): VideoItem {
            return VideoItem(
                position,
                "https://200024424.vod.myqcloud.com/200024424_709ae516bdf811e6ad39991f76a4df69.f20.mp4",
                thumbnail = "https://images.unsplash.com/photo-1648737154547-b0dfd281c51e?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=80&raw_url=true&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470",
                lastPlayedPosition = 0
            )
        }
    }
}