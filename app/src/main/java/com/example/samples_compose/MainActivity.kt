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
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.ChangeCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Print
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material3.DrawerValue.Closed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.NavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.largeTopAppBarColors
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.lifecycle.MutableLiveData
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.google.accompanist.systemuicontroller.rememberSystemUiController
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


    val colors = listOf(
        Color(0xFFffd7d7.toInt()),
        Color(0xFFffe9d6.toInt()),
        Color(0xFFfffbd0.toInt()),
        Color(0xFFe3ffd9.toInt()),
        Color(0xFFd0fff8.toInt())
    )

    @ExperimentalPermissionsApi
    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ProvideWindowInsets { // 必须使用，否则无法 Modifier.navigationBarsPadding() 会没有效果

                val isDarkModel:Boolean by isDark.observeAsState(isSystemInDarkTheme())

                RedTheme(isDarkModel) {

                    val systemUiController = rememberSystemUiController()

                    val decayAnimationSpec = rememberSplineBasedDecay<Float>()
                    val scrollBehavior = remember(decayAnimationSpec) {
                        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(decayAnimationSpec)
                    }

                    val drawerState = rememberDrawerState(Closed)
                    val scope = rememberCoroutineScope()
                    systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = false)
                    systemUiController.statusBarDarkContentEnabled = drawerState.isOpen

                    val position: Int? by positionLiveData.observeAsState()

                    val isRefreshing by vm.isRefresh.collectAsState(false)
                    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing)

                    val stateOfOpen = remember { mutableStateOf(false) }

                    var openDialog by stateOfOpen

                    if (openDialog) {
                        ShowDialog(stateOfOpen)
                    }

                    NavigationDrawer(
                        drawerState = drawerState,
                        drawerContent = {
                            Column(
                                modifier = Modifier
                                    .statusBarsPadding()
                                    .navigationBarsPadding()
                                    .fillMaxSize()
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
                            }
                        },
                        drawerContainerColor = MaterialTheme.colorScheme.background,
                        drawerContentColor = contentColorFor(backgroundColor = MaterialTheme.colorScheme.background),
                        content = {
                            Scaffold(
                                containerColor = MaterialTheme.colorScheme.background,
                                topBar = {
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
                                                isDark.postValue(!(isDark.value?:false))
                                            }) {
                                                Icon(
                                                    imageVector = Filled.ChangeCircle,
                                                    contentDescription = "Localized description",
                                                )
                                            }
                                        },
                                        colors = largeTopAppBarColors(
                                            containerColor = MaterialTheme.colorScheme.background,
                                            titleContentColor = contentColorFor(backgroundColor = MaterialTheme.colorScheme.background),
                                            actionIconContentColor = contentColorFor(backgroundColor = MaterialTheme.colorScheme.background),
                                            navigationIconContentColor = contentColorFor(MaterialTheme.colorScheme.background)
                                        ),
                                        scrollBehavior = scrollBehavior
                                    )
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
                                        text = { Text("Inc") },
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
                    )
                }
            }
        }
    }
}
