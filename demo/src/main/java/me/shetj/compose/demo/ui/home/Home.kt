package me.shetj.compose.demo.ui.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import me.shetj.compose.demo.MainViewModel
import me.shetj.compose.demo.ui.home.fun_mine.MineScreen
import me.shetj.compose.demo.ui.home.fun_netwrok.NetWorkScreen
import me.shetj.compose.demo.ui.home.home_func.FuncUI
import me.shetj.compose.demo.ui.home.home_weight.WidgetUI

@ExperimentalMaterial3Api
fun NavGraphBuilder.addHomeGraph(
    onSnackSelected: (String, NavBackStackEntry) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
) {
    composable(DemoHomeSections.WEIGHT.route) { from ->
        WidgetUI(modifier,onSnackSelected,from)
    }
    composable(DemoHomeSections.FUNC.route) { from ->
        FuncUI(modifier,onSnackSelected,from)
    }
    composable(DemoHomeSections.NETWORK.route) { from ->
        NetWorkUI(modifier,viewModel)
    }
    composable(DemoHomeSections.OTHER.route) {
        otherUI(modifier)
    }
}



@ExperimentalMaterial3Api
@Composable
fun NetWorkUI(modifier: Modifier, viewModel: MainViewModel) {
    NetWorkScreen(modifier,viewModel)
}

@Composable
fun otherUI(modifier: Modifier) {
     MineScreen()
}