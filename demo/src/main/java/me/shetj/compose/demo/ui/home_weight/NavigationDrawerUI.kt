package me.shetj.compose.demo.ui.home_weight

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.DismissibleNavigationDrawer
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.DrawerValue.Open
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawerUI(modifier: Modifier = Modifier) {
    DemoNavi(Open)

//    PermanentNavigationDrawerSample()

//    DismissibleNavigationDrawerSample()
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PermanentNavigationDrawerSample() {
    // icons to mimic drawer destinations
    val items = listOf(Icons.Default.Favorite, Icons.Default.Face, Icons.Default.Email)
    val selectedItem = remember { mutableStateOf(items[0]) }
    PermanentNavigationDrawer(
        drawerContent = {
            items.forEach { item ->
                NavigationDrawerItem(
                    icon = { Icon(item, contentDescription = null) },
                    label = { Text(item.name) },
                    selected = item == selectedItem.value,
                    onClick = {
                        selectedItem.value = item
                    },
                    modifier = Modifier.padding(horizontal = 12.dp)
                )
            }
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Application content")
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DismissibleNavigationDrawerSample() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    // icons to mimic drawer destinations
    val items = listOf(Icons.Default.Favorite, Icons.Default.Face, Icons.Default.Email)
    val selectedItem = remember { mutableStateOf(items[0]) }
    DismissibleNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {

            items.forEach { item ->
                NavigationDrawerItem(
                    icon = { Icon(item, contentDescription = null) },
                    label = { Text(item.name) },
                    selected = item == selectedItem.value,
                    onClick = {
                        scope.launch { drawerState.close() }
                        selectedItem.value = item
                    },
                    modifier = Modifier.padding(horizontal = 12.dp)
                )
            }
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = if (drawerState.isClosed) ">>> Swipe >>>" else "<<< Swipe <<<")
                Spacer(Modifier.height(20.dp))
                Button(onClick = { scope.launch { drawerState.open() } }) {
                    Text("Click to open")
                }
            }
        }
    )
}