package me.shetj.composekit.router

import android.app.PendingIntent
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.TaskStackBuilder
import androidx.core.net.toUri

/**
 *
 * <b>@author：</b> shetj<br>
 * <b>@createTime：</b> 2022/4/14<br>
 * <b>@email：</b> 375105540@qq.com<br>
 * <b>@describe</b>  <br>
 */
class Router {

    @Composable
    fun testBuildRouter() {
        val id = "exampleId"
        val context = LocalContext.current
        val deepLinkIntent = Intent(
            Intent.ACTION_VIEW,
            "https://www.example.com/$id".toUri(),
        )
        val deepLinkPendingIntent: PendingIntent? = TaskStackBuilder.create(context).run {
            addNextIntentWithParentStack(deepLinkIntent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }
    }
}

