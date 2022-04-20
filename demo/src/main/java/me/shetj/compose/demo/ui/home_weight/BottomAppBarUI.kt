package me.shetj.compose.demo.ui.home_weight

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.shetj.compose.demo.ui.home.DemoHomeSections
import me.shetj.composekit.ui.theme.getContext


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomAPPBar(modifier: Modifier = Modifier) {

    Scaffold(modifier = modifier,
        topBar = {
            DemoTopBar("BottomAPPBar")
        }) {

        Box(modifier = Modifier.fillMaxSize().padding(15.dp)) {
            var selectedItem by remember { mutableStateOf(0) }
            val items = DemoHomeSections.values()
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.surface,
            ) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = {
                            BadgedBox(badge = {
                            })
                            {
                                Icon(
                                    if (selectedItem == index) item.selectIcon else item.icon,
                                    contentDescription = item.route
                                )
                            }
                        },
                        label = { Text(getContext().getString(item.title)) },
                        selected = selectedItem == index,
                        onClick = {
                            selectedItem = index

                        },
                        colors = NavigationBarItemDefaults.colors(indicatorColor = MaterialTheme.colorScheme.surface),
                        alwaysShowLabel = true
                    )
                }
            }

        }
    }
}