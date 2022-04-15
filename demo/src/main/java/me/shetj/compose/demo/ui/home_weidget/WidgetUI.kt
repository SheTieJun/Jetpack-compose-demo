package me.shetj.compose.demo.ui.home_weidget

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier




@Composable
fun WidgetUI(modifier: Modifier) {
    Surface(modifier = modifier.fillMaxSize()) {
        Text(text = "控件列表", modifier = modifier.wrapContentSize())
    }
}