package me.shetj.compose.demo.ui.home.home_func

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.shetj.compose.demo.ui.home.home_weight.DemoTopBar

@OptIn(ExperimentalAnimationApi::class)
@ExperimentalMaterial3Api
@Composable
fun AnimationScreen() {


    //显示和隐藏
    var visible by remember { mutableStateOf(true) }
    var count by remember { mutableStateOf(0) }
    Scaffold(
        topBar = {
            DemoTopBar("Animation")
        }
    ) { padding ->

        Column() {
            Row() {

                Button(onClick = { count++ }) {
                    Text("Add")
                }

                AnimatedContent(
                    targetState = count,
                    modifier = Modifier.height(40.dp).align(CenterVertically),
                    transitionSpec = {
                        // Compare the incoming number with the previous number.
                        if (targetState > initialState) {
                            // If the target number is larger, it slides up and fades in
                            // while the initial (smaller) number slides up and fades out.
                            slideInVertically { height -> height } + fadeIn() with
                                    slideOutVertically { height -> -height } + fadeOut()
                        } else {
                            // If the target number is smaller, it slides down and fades in
                            // while the initial number slides down and fades out.
                            slideInVertically { height -> -height } + fadeIn() with
                                    slideOutVertically { height -> height } + fadeOut()
                        }.using(
                            // Disable clipping since the faded slide-in/out should
                            // be displayed out of bounds.
                            SizeTransform(clip = false)
                        )
                    }
                ) { targetCount ->
                    Text(text = "$targetCount", modifier = Modifier.fillMaxHeight())
                }

            }
            Row {
                Button(onClick = {  visible = !visible }) {
                    Text("Visibility")
                }
                AnimatedVisibility(visible = visible,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    Button(onClick = {
                        visible = !visible
                    }) {
                        Text(text = "AnimatedVisibility")
                    }
                }
            }
        }
    }

}