package me.shetj.compose.demo.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.twotone.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

@Composable
fun Navigation() {

    var selectedItem by remember { mutableStateOf(0) }

    val items = listOf("Favorite", "Artists", "Playlists")

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    BadgedBox(badge = { Badge { Text("8") } }) {
                        Icon(
                            if (selectedItem == index) Icons.Filled.Star else Icons.TwoTone.Star,
                            contentDescription = "Favorite"
                        )
                    }
                },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index },
                colors = NavigationBarItemDefaults.colors(indicatorColor =  MaterialTheme.colorScheme.primaryContainer),
                alwaysShowLabel = true
            )
        }
    }

}