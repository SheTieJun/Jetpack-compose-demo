package me.shetj.compose.demo.ui.home.home_weight

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 *
 * <b>@author：</b> shetj<br>
 * <b>@createTime：</b> 2022/4/21<br>
 * <b>@email：</b> 375105540@qq.com<br>
 * <b>@describe</b>  <br>
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProgressIndicatorUI(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier,
        topBar = {
            DemoTopBar("ProgressIndicator")
        }) {

        Column {
            CircularProgressIndicator(modifier = Modifier.size(100.dp, 100.dp))

            Spacer(Modifier.height(16.dp))

            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
            )
        }
    }

}