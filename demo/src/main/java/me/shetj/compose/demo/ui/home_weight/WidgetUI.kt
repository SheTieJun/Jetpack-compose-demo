
package me.shetj.compose.demo.ui.home_weight

import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.ChangeCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.shetj.compose.demo.model.BadgesManager
import me.shetj.compose.demo.model.WeightModel
import me.shetj.compose.demo.model.WeightRepo
import me.shetj.composekit.model.SnackbarManager
import me.shetj.composekit.utils.isDark


@ExperimentalMaterial3Api
@Composable
fun WidgetUI(modifier: Modifier) {
    Scaffold(modifier = modifier.fillMaxSize(),
        topBar = {
            DemoTopBar()
        }) { padding ->

        WidgetList(padding)
    }

}

@Composable
fun WidgetList(padding: PaddingValues) {
    val weights = WeightRepo.getWeights()
    LazyColumn(contentPadding = padding) {
        items(items = weights, key = { it.id }, itemContent = { item ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .clickable {

                        onClickItem(item)
                    }
                ,
              contentAlignment = Alignment.CenterStart
            ) {
                Text(text = item.name, modifier = Modifier.padding(15.dp,0.dp))
            }
        })
    }
}

private fun onClickItem(item: WeightModel) {
    when(item.name){
        "Badges" ->{
            BadgesManager.addBadges()
        }
        else ->{
            SnackbarManager.showMessage(item.name)
        }
    }
}


@ExperimentalMaterial3Api
@Composable
fun DemoTopBar() {

    val bgColor = MaterialTheme.colorScheme.background
    val decayAnimationSpec = rememberSplineBasedDecay<Float>()
    val scrollBehavior = remember(decayAnimationSpec) {
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(decayAnimationSpec)
    }
    SmallTopAppBar(
        modifier = Modifier.statusBarsPadding(),
        title = { Text("Compose Components") },
        navigationIcon = {
        },
        actions = {
            IconButton(onClick = {
                isDark.postValue(!(isDark.value ?: false))
            }) {
                Icon(
                    imageVector = Filled.ChangeCircle,
                    contentDescription = "change Theme",
                )
            }
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = bgColor,
            titleContentColor = contentColorFor(backgroundColor = bgColor),
            actionIconContentColor = contentColorFor(backgroundColor = bgColor),
            navigationIconContentColor = contentColorFor(bgColor),
            scrolledContainerColor = bgColor
        ),
        scrollBehavior = scrollBehavior
    )
}