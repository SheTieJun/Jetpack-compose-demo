package com.example.samples_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.largeTopAppBarColors
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding
import java.nio.file.WatchEvent
import me.shetj.composekit.ui.theme.DynamicTheme
import me.shetj.composekit.ui.theme.RedTheme
import me.shetj.composekit.ui.theme.SystemUIController
import me.shetj.composekit.ui.weight.LargeAppBar
import me.shetj.composekit.ui.weight.MidAppBar
import me.shetj.composekit.ui.weight.TopBar

class MainActivity : ComponentActivity() {

    val colors = listOf(
        Color(0xFFffd7d7.toInt()),
        Color(0xFFffe9d6.toInt()),
        Color(0xFFfffbd0.toInt()),
        Color(0xFFe3ffd9.toInt()),
        Color(0xFFd0fff8.toInt())
    )

    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            RedTheme {
                SystemUIController {
                    setSystemBarsColor(Color.Transparent, darkIcons = true)
                    statusBarDarkContentEnabled = true
                }

                val decayAnimationSpec = rememberSplineBasedDecay<Float>()
                val scrollBehavior = remember(decayAnimationSpec) {
                    TopAppBarDefaults.exitUntilCollapsedScrollBehavior(decayAnimationSpec)
                }
                ProvideWindowInsets {  //必须使用，否则无法 Modifier.navigationBarsPadding() 会没有效果
                    Scaffold(
                        topBar = {
                            MediumTopAppBar(
                                title = { Text("TopAppBar") },
                                navigationIcon = {
                                    IconButton(onClick = { /* doSomething() */ }) {
                                        Icon(
                                            imageVector = Filled.Menu,
                                            contentDescription = "Localized description"
                                        )
                                    }
                                },
                                actions = {
                                    IconButton(onClick = { /* doSomething() */ }) {
                                        Icon(
                                            imageVector = Filled.Favorite,
                                            contentDescription = "Localized description"
                                        )
                                    }
                                },
                                colors = largeTopAppBarColors(containerColor = Color.Transparent),
                                scrollBehavior = scrollBehavior
                            )

                        },
                        floatingActionButtonPosition = FabPosition.End,
                        floatingActionButton = {
                            ExtendedFloatingActionButton(
                                text = { Text("Inc") },
                                onClick = { /* fab click handler */ }
                            )
                        },
                        modifier = Modifier
                            .statusBarsPadding()
                            .navigationBarsPadding()
                            .nestedScroll(scrollBehavior.nestedScrollConnection),
                    ) { innerPadding ->
                        LazyColumn(contentPadding = innerPadding) {
                            items(count = 100) {
                                Box(
                                    Modifier
                                        .fillMaxWidth()
                                        .height(50.dp)
                                        .background(colors[it % colors.size])
                                )
                            }
                        }
                    }
                }
            }


        }
    }
}
