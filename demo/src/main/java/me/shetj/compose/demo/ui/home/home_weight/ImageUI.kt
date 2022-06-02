package me.shetj.compose.demo.ui.home.home_weight

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.shetj.compose.demo.R
import me.shetj.composekit.ui.weight.CirImage
import me.shetj.composekit.ui.weight.CornerImage
import me.shetj.composekit.ui.weight.ImageHasLoading
import me.shetj.composekit.ui.weight.LocalImage
import me.shetj.composekit.ui.weight.NetworkImage


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageUI(modifier: Modifier = Modifier) {

    Scaffold(modifier = modifier,
        topBar = {
            DemoTopBar("Images")
        }) {
        LazyColumn(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.onSecondaryContainer)
                .fillMaxSize()
                .padding(start = 15.dp)
        ) {

            item {
                //1. 圆image

                CirImage(res = R.mipmap.compose_logo)

                Spacer(Modifier.height(16.dp))

                //2. 圆角image
                CornerImage(
                    res = R.mipmap.compose_logo, modifier = Modifier
                        .width(100.dp)
                        .height(100.dp), 15.dp
                )


                Spacer(Modifier.height(16.dp))
                //1.本地图片
            }
            item {

                //2.网络图片
                NetworkImage(
                    url = "https://dev-1253442168.cosgz.myqcloud.com/avatar/9542e9b715eab88972044e55ecdc81e2.jpeg",
                    contentDescription = "网络图片",
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                )

                Spacer(Modifier.height(16.dp))
                ImageHasLoading(
                    url = R.drawable.ic_androidjetpack,
                    contentDescription = "网络图片",
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                )

                Spacer(Modifier.height(16.dp))
                //3.本地资源图片
                LocalImage(res = R.mipmap.compose_logo)
            }
        }
    }

}

