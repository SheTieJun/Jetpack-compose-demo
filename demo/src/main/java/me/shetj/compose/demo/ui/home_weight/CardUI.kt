package me.shetj.compose.demo.ui.home_weight

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.shetj.compose.demo.R.mipmap
import me.shetj.composekit.ui.gesture.drag
import me.shetj.composekit.ui.weight.CornerImage

/**
 *
 * <b>@author：</b> shetj<br>
 * <b>@createTime：</b> 2022/4/20<br>
 * <b>@email：</b> 375105540@qq.com<br>
 * <b>@describe</b>  <br>
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardUI(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier,
        topBar = {
            DemoTopBar("Cards")
        }) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(start = 15.dp)) {

            //1. Card	M3 card
            Card(
                Modifier
                    .size(width = 180.dp, height = 100.dp)
                    .padding(5.dp)
                    .drag()) {
                CornerImage(res = mipmap.compose_logo, modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),15.dp)
                TextButton(onClick = {  }) { Text("TextButton") }
            }
            Spacer(Modifier.height(16.dp))


            //2. ElevatedCard	M3 elevated card
            ElevatedCard(
                Modifier
                    .size(width = 180.dp, height = 100.dp)
                    .padding(5.dp)) {
                CornerImage(res = mipmap.compose_logo, modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),15.dp)
                TextButton(onClick = { /* Do something! */ }) { Text("TextButton") }
            }
            Spacer(Modifier.height(16.dp))


            //3. OutlinedCard	M3 outlined card
            OutlinedCard(
                Modifier
                    .size(width = 180.dp, height = 100.dp)
                    .padding(5.dp)) {
                CornerImage(res = mipmap.compose_logo, modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),15.dp)
                TextButton(onClick = { /* Do something! */ }) { Text("TextButton") }
            }
            Spacer(Modifier.height(16.dp))

        }
    }

}