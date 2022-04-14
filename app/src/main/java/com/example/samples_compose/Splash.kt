/*
 * MIT License
 *
 * Copyright (c) 2019 SheTieJun
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.example.samples_compose

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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay
import me.shetj.composekit.ui.theme.RedTheme
import me.shetj.composekit.ui.theme.getContext

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {

            val systemUiController = rememberSystemUiController()
            systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = true)

            // A surface container using the 'background' color from the theme
            ProvideWindowInsets(consumeWindowInsets = true) {
                Surface(color = MaterialTheme.colorScheme.background) {
                    SplashScreen {
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
            .fillMaxWidth() // match_parent
            .fillMaxHeight(),
        alignment = Alignment.Center,
        contentScale = ContentScale.Crop, // scaleType
        alpha = 0.5f,
    )
}

@Composable
fun SplashScreen(onFinish: (() -> Unit)? = null) {
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
                }
            )
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
