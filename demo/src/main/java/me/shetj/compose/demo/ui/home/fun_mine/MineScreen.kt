package me.shetj.compose.demo.ui.home.fun_mine

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import me.shetj.compose.demo.R
import me.shetj.composekit.ui.theme.MD3
import me.shetj.composekit.ui.theme.cir
import me.shetj.composekit.ui.weight.LocalImage

@Composable
fun MineScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()

        ) {

            Row(
                modifier = Modifier
                    .wrapContentWidth()
                    .height(130.dp)
                    .align(CenterStart)
                    .padding(20.dp)
                    .background(MD3.colorScheme.background),
                verticalAlignment = CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {

                LocalImage(
                    res = R.mipmap.bg_android_jetpack,
                    modifier = Modifier
                        .width(80.dp)
                        .height(80.dp)
                        .cir(),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "Android Dev",
                    color = MD3.colorScheme.contentColorFor(MD3.colorScheme.background),
                    style = MD3.typography.headlineSmall,
                    modifier = Modifier.offset(15.dp)
                )
            }

        }

        LazyColumn(modifier = Modifier.fillMaxHeight().padding(start = 15.dp, end = 15.dp)) {

            item {
               CaseButton("case1")
                Spacer(modifier = Modifier.height(10.dp))
            }

            item {
                CaseButton("case2")
                Spacer(modifier = Modifier.height(10.dp))
            }
            item {
                CaseButton("case3")
                Spacer(modifier = Modifier.height(10.dp))
            }
        }

    }
}