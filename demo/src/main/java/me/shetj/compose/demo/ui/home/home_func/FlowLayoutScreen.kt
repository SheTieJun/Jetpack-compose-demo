package me.shetj.compose.demo.ui.home.home_func

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.ViewColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowColumn
import com.google.accompanist.flowlayout.FlowRow
import me.shetj.compose.demo.ui.home.home_weight.DemoTopBar
import me.shetj.composekit.ui.theme.MD3

/**
 *
 * <b>@author：</b> shetj<br>
 * <b>@createTime：</b> 2022/5/23<br>
 * <b>@email：</b> 375105540@qq.com<br>
 * <b>@describe</b>  <br>
 */
@ExperimentalMaterial3Api
@Composable
fun FlowLayoutScreen() {

    var isRow by remember {
        mutableStateOf(true)
    }

    Scaffold(
        topBar = {
            DemoTopBar("FlowLayout")
        },
        floatingActionButton = {
            Icon(if (isRow) Icons.Filled.GridView else Icons.Filled.ViewColumn,
                contentDescription = "切换",
                modifier = Modifier
                    .padding(5.dp)
                    .size(45.dp)
                    .clickable {
                        isRow = !isRow
                    })
        }
    ) { padding ->
        if (isRow) {
            FlowRow(Modifier.padding(padding)) {
                SampleContent()
            }
        } else {
            FlowColumn(Modifier.padding(padding)) {
                SampleContent()
            }
        }
    }


}

@Composable
internal fun SampleContent() {
    repeat(30) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .background(MD3.colorScheme.errorContainer)
                .border(2.dp, contentColorFor(MD3.colorScheme.errorContainer)),
            contentAlignment = Alignment.Center,
        ) {
            Text(it.toString())
        }
    }
}