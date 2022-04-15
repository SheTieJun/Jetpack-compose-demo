package me.shetj.compose.demo.ui.components

import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import me.shetj.compose.demo.DemoAppState
import me.shetj.compose.demo.ui.home.DemoHomeSections
import me.shetj.composekit.ui.theme.getContext

@Composable
fun BottomBar(appState: DemoAppState) {

    var selectedItem by remember { mutableStateOf(0) }

    val items = DemoHomeSections.values()

    NavigationBar(
        containerColor = Color.White,
        contentColor = Color.White,
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    BadgedBox(badge = {
//                        Badge { Text("8") }
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
                    appState.navigateToBottomBarRoute(item.route)
                },
                colors = NavigationBarItemDefaults.colors(indicatorColor = MaterialTheme.colorScheme.background),
                alwaysShowLabel = true
            )
        }
    }

}