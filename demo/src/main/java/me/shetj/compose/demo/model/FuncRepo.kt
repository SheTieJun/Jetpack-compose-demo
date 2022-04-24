package me.shetj.compose.demo.model

import androidx.compose.runtime.Immutable
import me.shetj.compose.demo.model.FuncRepo.keyId

/**
 *
 * <b>@author：</b> shetj<br>
 * <b>@createTime：</b> 2022/4/22<br>
 * <b>@email：</b> 375105540@qq.com<br>
 * <b>@describe</b>  <br>
 */
object FuncRepo {

    fun getFuncList() = funcCollection

    var keyId = 0L
}

//不可变
@Immutable
data class FuncModel(
    val id: Long,
    val name: String,
)


val webview = FuncModel(
    id = keyId ++,
    name = "WebView"
)

val videoView = webview.copy(
    id = keyId++,
    name = "VideoView"
)


val bottomSheet = webview.copy(
    id = keyId++,
    name = "BottomSheet"
)

val viewPage = webview.copy(
    id = keyId++,
    name = "ViewPage"
)

val Canvas = webview.copy(
    id = keyId++,
    name = "Canvas"
)

val funcCollection = listOf(
    webview,
    bottomSheet,
    viewPage,
    videoView,
    Canvas
)

