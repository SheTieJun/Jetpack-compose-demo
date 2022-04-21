package me.shetj.compose.demo.ui.home_weight

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.Modifier.Companion
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

/**
 *
 * <b>@author：</b> shetj<br>
 * <b>@createTime：</b> 2022/4/20<br>
 * <b>@email：</b> 375105540@qq.com<br>
 * <b>@describe</b>  <br>
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarUI(modifier: Modifier = Modifier, expand: Boolean) {

    val rememberExpanded = remember { mutableStateOf(expand) }

    val offset = remember { mutableStateOf(DpOffset(0.dp, 30.dp)) }
    Scaffold(
        modifier = modifier,
        topBar = {
            DemoTopBar("TopAppBars")
        }, containerColor = MaterialTheme.colorScheme.onBackground
    ) {

        var expanded by rememberExpanded

        if (expanded) {
            MenuUI(expanded = rememberExpanded, offset.value)
        }

        Column() {
            Spacer(modifier = Modifier.height(16.dp))
            //1.SmallTopAppBar	M3 small top app bar
            SmallTopAppBar(
                title = { Text("Simple TopAppBar") },
                navigationIcon = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {
                        expanded = true
                        offset.value = DpOffset(0.dp, 30.dp)
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = "Localized description"
                        )
                    }
                }
            )

            Spacer(modifier = Modifier.height(16.dp))
            //2. CenterAlignedTopAppBar	M3 center-aligned top app bar
            CenterAlignedTopAppBar(
                title = { Text("Centered TopAppBar") },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {
                        expanded = true
                        offset.value = DpOffset(0.dp,110.dp)
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = "Localized description"
                        )
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            //3. MediumTopAppBar	M3 medium top app bar
            MediumTopAppBar(
                title = { Text("Medium TopAppBar") },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { expanded = true
                        offset.value = DpOffset(0.dp,180.dp)
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = "Localized description"
                        )
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            //4. LargeTopAppBar	M3 large top app bar
            LargeTopAppBar(
                title = { Text("Large TopAppBar") },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { expanded = true
                        offset.value = DpOffset(0.dp,300.dp)
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                }
            )
        }
    }
}