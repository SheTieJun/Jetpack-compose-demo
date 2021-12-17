package com.example.samples_compose

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.ProvideWindowInsets
import kotlinx.coroutines.delay
import me.shetj.composekit.ui.theme.RedTheme
import me.shetj.composekit.ui.theme.SystemUIController
import me.shetj.composekit.ui.theme.getContext

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)


        setContent {

            SystemUIController {
                setSystemBarsColor(Color.Transparent, darkIcons = true)
            }

            // A surface container using the 'background' color from the theme
            ProvideWindowInsets(consumeWindowInsets = true) {
                Surface(color = MaterialTheme.colorScheme.background) {
                    SplashScreen{
                        finish()
                    }

                }
            }
        }
    }


}

@Composable
fun Greeting2() {
    Image(
        painter = painterResource(id = R.drawable.cathedral_rock),
        contentDescription = "pic",
        modifier = Modifier
            .fillMaxWidth() //match_parent
            .fillMaxHeight(),
        alignment = Alignment.Center,
        contentScale = ContentScale.Crop, //scaleType
        alpha = 0.5f,
    )
}

@Composable
fun SplashScreen(onFinish:(()->Unit)? = null) {
    val scale = remember {
        Animatable(0f)
    }
    val context = getContext()
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            // tween Animation
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        // Customize the delay time
        delay(1000L)
        context.startActivity(Intent(context, MainActivity::class.java))
        onFinish?.invoke()
    }


    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = " Hello  ",
            modifier = Modifier.scale(scale.value),
            fontSize = MaterialTheme.typography.displayLarge.fontSize
        )
        Greeting2()
    }

}




@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    RedTheme {
        Greeting2()
    }
}