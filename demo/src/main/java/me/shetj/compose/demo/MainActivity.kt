package me.shetj.compose.demo

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.BounceInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@ExperimentalPermissionsApi
@ExperimentalPagerApi
@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {

    private var splashScreen: SplashScreen? =null
    private var isKeep = true


    override fun onCreate(savedInstanceState: Bundle?) {
        splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        lifecycleScope.launch {
            delay(1000)
            isKeep = false
        }
        splashScreen!!.setKeepOnScreenCondition(SplashScreen.KeepOnScreenCondition {
            //指定保持启动画面展示的条件
            return@KeepOnScreenCondition isKeep
        })
        splashScreen!!.setOnExitAnimationListener { splashScreenViewProvider ->
            val splashScreenView = splashScreenViewProvider.view
//            // Get the duration of the animated vector drawable.
//            val animationDuration = splashScreenViewProvider.iconAnimationDurationMillis
//// Get the start time of the animation.
//            val animationStart = splashScreenViewProvider.iconAnimationStartMillis
//// Calculate the remaining duration of the animation.
//            val remainingDuration = (animationDuration - (animationStart - System.currentTimeMillis()))
//                .coerceAtLeast(0L)


            val slideUp = ObjectAnimator.ofFloat(
                splashScreenView,
                View.ALPHA,
                1f,
                0f,
            )
            slideUp.duration = 800
            slideUp.doOnEnd {
//                splashScreenViewProvider.remove()
            }
            slideUp.start()
        }
        setContent {
            DemoApp()
        }
    }
}
