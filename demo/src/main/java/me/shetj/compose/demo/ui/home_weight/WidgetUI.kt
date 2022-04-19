package me.shetj.compose.demo.ui.home_weight

import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.ChangeCircle
import androidx.compose.material.icons.filled.HomeMini
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import me.shetj.compose.demo.model.BadgesManager
import me.shetj.compose.demo.model.WeightRepo
import me.shetj.compose.demo.ui.home.BASE_WEIGHT_ROUTER
import me.shetj.compose.demo.ui.home.DemoWeightSections
import me.shetj.composekit.utils.isDark


@ExperimentalMaterial3Api
@Composable
fun WidgetUI(modifier: Modifier, onSnackSelected: (String, NavBackStackEntry) -> Unit, from: NavBackStackEntry) {
    Scaffold(modifier = modifier.fillMaxSize(),
        topBar = {
            DemoTopBar("Compose Components")
        }) { padding ->

        WidgetList(padding,onSnackSelected,from)
    }

}

@Composable
fun WidgetList(
    padding: PaddingValues,
    onSnackSelected: (String, NavBackStackEntry) -> Unit,
    from: NavBackStackEntry
) {
    val weights = WeightRepo.getWeights()
    LazyColumn(contentPadding = padding) {
        items(items = weights, key = { it.id }, itemContent = { item ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .clickable {
                        when (item.name) {
                            "Badges" -> {
                                BadgesManager.addBadges()
                            }
                            else -> {
                                onSnackSelected.invoke("$BASE_WEIGHT_ROUTER/${item.name}",from)
                            }
                        }
                    },
                contentAlignment = Alignment.CenterStart
            ) {
                Text(text = item.name, modifier = Modifier.padding(15.dp, 0.dp))
            }
        })
    }
}


@ExperimentalMaterial3Api
@Composable
fun DemoTopBar(title: String) {

    val bgColor = MaterialTheme.colorScheme.background
    val decayAnimationSpec = rememberSplineBasedDecay<Float>()
    val scrollBehavior = remember(decayAnimationSpec) {
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(decayAnimationSpec)
    }
    SmallTopAppBar(
        modifier = Modifier.statusBarsPadding(),
        title = {
            Row {
                Icon(
                    imageVector = Filled.HomeMini,
                    contentDescription = "change Theme",
                )
                Text(title)
            }
        },
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


@ExperimentalMaterial3Api
fun NavGraphBuilder.addWeightGraph(modifier: Modifier = Modifier) {
    composable(DemoWeightSections.IMAGES.route) { from ->
        ImageUI(modifier)
    }
//    composable(DemoWeightSections.BUTTON.route) { from ->
//    }
}