@file:OptIn(ExperimentalMaterial3Api::class)

package me.shetj.compose.demo.ui.home.home_func

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import me.shetj.compose.demo.DemoAppState
import me.shetj.compose.demo.MainViewModel
import me.shetj.compose.demo.model.FuncRepo
import me.shetj.compose.demo.ui.home.BASE_FUNC_ROUTER
import me.shetj.compose.demo.ui.home.DemoFuncSections
import me.shetj.compose.demo.ui.home.home_weight.DemoTopBar
import me.shetj.compose.demo.ui.home.home_weight.ShowTipDialog
import me.shetj.composekit.ui.weight.ShowPermissionDialog

/**
 *
 * <b>@author：</b> shetj<br>
 * <b>@createTime：</b> 2022/4/24<br>
 * <b>@email：</b> 375105540@qq.com<br>
 * <b>@describe</b>  <br>
 */
@ExperimentalAnimationApi
@ExperimentalPermissionsApi
@ExperimentalPagerApi
@ExperimentalMaterial3Api
fun NavGraphBuilder.addFuncGraph(
    appState: DemoAppState,
    modifier: Modifier =Modifier,
    viewModel: MainViewModel? = null
) {
    composable(DemoFuncSections.WebView.route) { from ->
        WebViewUI(modifier)
    }
    composable(DemoFuncSections.ViewPage.route) { from ->
        PagerUI(modifier)
    }
    composable(DemoFuncSections.Record.route) {
        RecordUI(modifier)
    }
    composable(DemoFuncSections.VideoView.route) {
        VideoScreen(modifier)
    }
    composable(DemoFuncSections.Canvas.route) {
        CanvasScreen()
    }
    composable(DemoFuncSections.FlowLayout.route) {
        FlowLayoutScreen()
    }
    composable(DemoFuncSections.Animation.route) {
        AnimationScreen()
    }
}

@ExperimentalMaterial3Api
@Composable
fun FuncUI(
    modifier: Modifier = Modifier,
    onSnackSelected: (String, NavBackStackEntry) -> Unit,
    from: NavBackStackEntry
) {
    Scaffold(modifier = modifier.fillMaxSize(),
        topBar = {
            DemoTopBar("Function Sample")
        }) { padding ->

        FuncList(padding, onSnackSelected, from)
    }
}

@Composable
fun FuncList(
    padding: PaddingValues,
    onSnackSelected: (String, NavBackStackEntry) -> Unit,
    from: NavBackStackEntry
) {
    val weights = FuncRepo.getFuncList()
    val map = DemoFuncSections.values().map { it.route }
    val isShow = remember {
        mutableStateOf(false)
    }
    if (isShow.value) {
        ShowTipDialog(isShow)
    }

    val stateOfOpen = remember { mutableStateOf(false) }

    val openDialog by stateOfOpen

    if (openDialog) {
        ShowPermissionDialog(openDialog = stateOfOpen)
    }

    LazyColumn(contentPadding = padding) {
        items(items = weights, key = { it.id }, itemContent = { item ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .clickable {
                        when (item.name) {
                            "x" -> {

                            }
                            else -> {
                                val router = "$BASE_FUNC_ROUTER/${item.name}"
                                val contains = map.contains(router)
                                if (contains) {
                                    onSnackSelected.invoke(router, from)
                                } else {
                                    isShow.value = true
                                }
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

@Composable
fun ShowTipFuncDialog(isShow: MutableState<Boolean>) {
    AlertDialog(
        onDismissRequest = {
            isShow.value = false
        },
        title = {
            Text(text = "Function Sample")
        },
        text = {
            val textToShow = "当前功能暂未完成~"
            Text(textToShow)
        },
        confirmButton = {
            TextButton(
                onClick = {
                    isShow.value = false
                }
            ) {
                Text("I Know")
            }
        }
    )
}