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

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.DismissDirection.EndToStart
import androidx.compose.material.DismissDirection.StartToEnd
import androidx.compose.material.DismissValue.Default
import androidx.compose.material.DismissValue.DismissedToEnd
import androidx.compose.material.DismissValue.DismissedToStart
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.ChangeCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Print
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material.rememberDismissState
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue.Closed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.largeTopAppBarColors
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.lifecycle.MutableLiveData
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import me.shetj.composekit.ui.theme.RedTheme
import me.shetj.composekit.ui.weight.DrawerButton
import me.shetj.composekit.ui.weight.ShowDialog
import me.shetj.composekit.utils.isDark
import me.shetj.composekit.utils.showToast

class MainActivity : ComponentActivity() {
    val positionLiveData = MutableLiveData<Int>(0)

    val vm: MainVM by viewModels()

    val list = mutableStateListOf<Pair<String, Color>>(
        "0xFFffd7d7" to Color(0xF1ffd701.toInt()),
        "0xFFffd7d7" to Color(0xF2ffd702.toInt()),
        "0xFFffd7d7" to Color(0xF3e3ff33.toInt()),
        "0xFFffe9d6" to Color(0xF4ffd7d4.toInt()),
        "0xFFffe9d6" to Color(0xF5ffd7d5.toInt()),
        "0xFFffe9d6" to Color(0xF6ffd7d6.toInt()),
        "0xFFffd7d7" to Color(0xF7ffd7d7.toInt()),
        "0xFFffe9d6" to Color(0xF8ffd7d8.toInt()),
        "0xFFffe9d6" to Color(0xF9d0fff9.toInt()),
        "0xFFfffbd0" to Color(0x10ffd711.toInt()),
        "0xFFd0fff8" to Color(0x11ffd710.toInt()),
        "0xFFfffbd0" to Color(0x12ffd712.toInt()),
        "0xFFfffbd0" to Color(0x13ffd713.toInt()),
        "0xFFfffbd0" to Color(0x22e3ff14.toInt()),
        "0xFFfffbd0" to Color(0x33d0ff15.toInt()),
        "0xFFd0fff8" to Color(0x44ffd716.toInt()),
        "0xFFd0fff8" to Color(0x55fffb17.toInt()),
        "0xFFd0fff8" to Color(0x66ffd718.toInt()),
        "0xFFd0fff8" to Color(0x77ffe919.toInt())
    )

    @OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ProvideWindowInsets { // 必须使用，否则无法 Modifier.navigationBarsPadding() 会没有效果

                val isDarkModel: Boolean by isDark.observeAsState(isSystemInDarkTheme())

                RedTheme(isDarkModel) {

                    val systemUiController = rememberSystemUiController()

                    val decayAnimationSpec = rememberSplineBasedDecay<Float>()
                    val scrollBehavior = remember(decayAnimationSpec) {
                        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(decayAnimationSpec)
                    }

                    val drawerState = rememberDrawerState(Closed)
                    val scope = rememberCoroutineScope()  // 用来做协程的作用域
                    systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = false)
                    systemUiController.statusBarDarkContentEnabled = !isDarkModel

                    val position: Int? by positionLiveData.observeAsState()

                    val isRefreshing by vm.isRefresh.collectAsState(false)
                    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing)

                    val stateOfOpen = remember { mutableStateOf(false) }

                    var openDialog by stateOfOpen

                    val bgColor = MaterialTheme.colorScheme.background

                    val remap = remember {
                        list
                    }

                    if (openDialog) {
                        ShowDialog(stateOfOpen)
                    }
                    ModalNavigationDrawer(
                        drawerState = drawerState,
                        drawerContent = {
                            drawerCase(position, scope, drawerState)
                        },
                        drawerContainerColor = bgColor,
                        drawerContentColor = contentColorFor(backgroundColor = bgColor),
                        content = {
                            Scaffold(
                                containerColor = bgColor,
                                topBar = {
                                    AppBar(scope, drawerState, bgColor, scrollBehavior)
                                },
                                floatingActionButtonPosition = FabPosition.End,
                                floatingActionButton = {
                                    ExtendedFloatingActionButton(
                                        icon = {
                                            Icon(
                                                imageVector = Filled.Favorite,
                                                contentDescription = "Icon"
                                            )
                                        },
                                        text = {
                                            Text("Inc")
                                        },
                                        onClick = {
                                            openDialog = true
                                        }
                                    )
                                },
                                modifier = Modifier
                                    .nestedScroll(scrollBehavior.nestedScrollConnection),
                            ) { innerPadding ->

                                SwipeRefresh(state = swipeRefreshState,
                                    onRefresh = {
                                        scope.launch {
                                            showToast("开始刷新")
                                            vm.isRefresh.emit(true)
                                            delay(1500)
                                            vm.isRefresh.emit(false)
                                        }
                                    }) {
                                    lyColumn(innerPadding, remap)
                                }
                            }
                        }
                    )
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun drawerCase(
        position: Int?,
        scope: CoroutineScope,
        drawerState: DrawerState
    ) {
        Column(
            modifier = Modifier
                .statusBarsPadding()
                .navigationBarsPadding()
        ) {
            DrawerButton(
                icon = Filled.Menu,
                label = "更多",
                isSelected = position == 0,
                action = {
                    positionLiveData.postValue(0)
                    scope.launch {
                        drawerState.close()
                    }
                }
            )
            DrawerButton(
                icon = Filled.Email,
                label = "邮件",
                isSelected = position == 1,
                action = {
                    positionLiveData.postValue(1)
                    scope.launch {
                        drawerState.close()
                    }
                }
            )
            DrawerButton(
                icon = Filled.Print,
                label = "微课",
                isSelected = position == 2,
                action = {
                    positionLiveData.postValue(2)
                    scope.launch {
                        drawerState.close()
                    }
                }
            )
            DrawerButton(
                icon = Filled.Book,
                label = "梨花",
                isSelected = position == 3,
                action = {
                    positionLiveData.postValue(3)
                    scope.launch {
                        drawerState.close()
                    }
                }
            )
            DrawerButton(
                icon = Filled.VideoLibrary,
                label = "视频",
                isSelected = position == 4,
                action = {
                    positionLiveData.postValue(4)
                    scope.launch {
                        drawerState.close()
                    }
                }
            )
            Button(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp),
                onClick = { scope.launch { drawerState.close() } },
                content = { Text("Close Drawer") }
            )
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun AppBar(
        scope: CoroutineScope,
        drawerState: DrawerState,
        bgColor: Color,
        scrollBehavior: TopAppBarScrollBehavior
    ) {
        MediumTopAppBar(
            modifier = Modifier.statusBarsPadding(),
            title = { Text("TopAppBar") },
            navigationIcon = {
                IconButton(onClick = { scope.launch { drawerState.open() } }) {
                    Icon(
                        imageVector = Filled.Menu,
                        contentDescription = "Localized description",
                    )
                }
            },
            actions = {
                IconButton(onClick = {
                    isDark.postValue(!(isDark.value ?: false))
                }) {
                    Icon(
                        imageVector = Filled.ChangeCircle,
                        contentDescription = "Localized description",
                    )
                }
            },
            colors = largeTopAppBarColors(
                containerColor = bgColor,
                titleContentColor = contentColorFor(backgroundColor = bgColor),
                actionIconContentColor = contentColorFor(backgroundColor = bgColor),
                navigationIconContentColor = contentColorFor(bgColor),
                scrolledContainerColor = bgColor
            ),
            scrollBehavior = scrollBehavior
        )
    }

    @OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
    @Composable
    private fun lyColumn(
        innerPadding: PaddingValues,
        remap: SnapshotStateList<Pair<String, Color>>
    ) {
        LazyColumn(contentPadding = innerPadding) {

            val groupBy = remap.groupBy { it.first }

            groupBy.forEach { valueEntry ->

                stickyHeader {
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .background(MaterialTheme.colorScheme.error),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            text = valueEntry.key,
                            textAlign = TextAlign.Center,
                            color = contentColorFor(MaterialTheme.colorScheme.error)
                        )
                    }
                }

                /**
                 * 这里必须实现key 方法，否则删除的时候会出现 空白的问题
                 */
                items(items = valueEntry.value, { it.second.toString() }) { item ->
                    val dismissState = rememberDismissState(confirmStateChange = {
                        if (it == DismissedToEnd || it == DismissedToStart) {
                            remap.remove(item)
                        }
                        return@rememberDismissState true
                    })

                    SwipeToDismiss(
                        state = dismissState,
                        background = {},
                        dismissThresholds = {
                            FractionalThreshold(0.5f)
                        },
                        directions = setOf(EndToStart, StartToEnd)  //设置滑动移除的方向
                    ) {
                        Box(
                            Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .background(item.second)
                        )
                    }
                }
            }

        }
    }
}


