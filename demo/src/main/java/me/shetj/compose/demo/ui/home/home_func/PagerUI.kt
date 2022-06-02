package me.shetj.compose.demo.ui.home.home_func

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.HorizontalRule
import androidx.compose.material.icons.filled.VerticalShades
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ScaleFactor
import androidx.compose.ui.layout.lerp
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import kotlin.math.absoluteValue
import me.shetj.compose.demo.ui.home.home_weight.DemoTopBar

/**
 *
 * <b>@author：</b> shetj<br>
 * <b>@createTime：</b> 2022/4/24<br>
 * <b>@email：</b> 375105540@qq.com<br>
 * <b>@describe</b>  <br>
 */
@ExperimentalPagerApi
@ExperimentalMaterial3Api
@Composable
fun PagerUI(modifier: Modifier = Modifier) {


    var isH by remember {
        mutableStateOf(true)
    }


    val pagerState = rememberPagerState()

    Scaffold(modifier = modifier,
        topBar = {
            DemoTopBar("Pager") {
                IconButton(onClick = {
                    isH = !isH
                }) {
                    Icon(
                        imageVector = if (isH) Filled.VerticalShades else Filled.HorizontalRule,
                        contentDescription = "change Theme",
                    )
                }
            }
        }) {

        if (isH) {
            HPager(modifier,pagerState)
        } else {
            VerticalPager(modifier,pagerState)
        }
        Box(modifier = Modifier.fillMaxSize()) {
            HorizontalPagerIndicator(
                pagerState = pagerState,
                modifier = Modifier.align(Alignment.BottomCenter)
                    .padding(bottom = 20.dp)
            )
        }
    }
}

@ExperimentalPagerApi
@ExperimentalMaterial3Api
@Composable
private fun HPager(modifier: Modifier, pagerState: PagerState) {
    HorizontalPager(
        count = 10,
        state = pagerState,
        // Add 32.dp horizontal padding to 'center' the pages
        contentPadding = PaddingValues(20.dp),
        modifier = modifier.fillMaxSize()
    ) { page ->
        Card(
            Modifier
                .graphicsLayer {
                    // Calculate the absolute offset for the current page from the
                    // scroll position. We use the absolute value which allows us to mirror
                    // any effects for both directions
                    val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                    // We animate the scaleX + scaleY, between 85% and 100%
                    lerp(
                        start = ScaleFactor(0.85f, 0.85f),
                        stop = ScaleFactor(1f, 1f),
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).also { scale ->
                        scaleX = scale.scaleX
                        scaleY = scale.scaleY
                    }

                    // We animate the alpha, between 50% and 100%
                    alpha = lerp(
                        start = ScaleFactor(0.5f, 0.5f),
                        stop = ScaleFactor(1f, 1f),
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).component1()

                    Log.i("graphicsLayer", "alpha:$alpha scaleX:$scaleX scaleY:$scaleY")
                }
                .fillMaxWidth()
                .fillMaxHeight()
//                    .aspectRatio(1f)
        ) {
            Text(
                text = "Page: $page",
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@ExperimentalPagerApi
@ExperimentalMaterial3Api
@Composable
private fun VerticalPager(modifier: Modifier,pagerState: PagerState) {
    VerticalPager(
        count = 10,
        state = pagerState,
        // Add 32.dp horizontal padding to 'center' the pages
        contentPadding = PaddingValues(10.dp),
        modifier = modifier.fillMaxSize()
    ) { page ->
        Card(
            Modifier
                .graphicsLayer {
                    // Calculate the absolute offset for the current page from the
                    // scroll position. We use the absolute value which allows us to mirror
                    // any effects for both directions
                    val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                    // We animate the scaleX + scaleY, between 85% and 100%
                    lerp(
                        start = ScaleFactor(0.85f, 0.85f),
                        stop = ScaleFactor(1f, 1f),
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                        .also { scale ->
                            scaleX = scale.scaleX
                            scaleY = scale.scaleY
                        }

                    // We animate the alpha, between 50% and 100%
                    alpha = lerp(
                        start = ScaleFactor(0.5f, 0.5f),
                        stop = ScaleFactor(1f, 1f),
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                        .component1()

                    Log.i("graphicsLayer", "alpha:$alpha scaleX:$scaleX scaleY:$scaleY")
                }
                .fillMaxWidth()
                .fillMaxHeight()
//                    .aspectRatio(1f)
        ) {
            Text(
                text = "Page: $page",
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}