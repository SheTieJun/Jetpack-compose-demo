package me.shetj.compose.demo.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import me.shetj.compose.demo.ui.home.fun_mine.MineScreen
import me.shetj.compose.demo.ui.home.home_func.FuncUI
import me.shetj.compose.demo.ui.home.home_weight.WidgetUI

@ExperimentalMaterial3Api
fun NavGraphBuilder.addHomeGraph(
    onSnackSelected: (String, NavBackStackEntry) -> Unit,
    modifier: Modifier = Modifier
) {
    composable(DemoHomeSections.WEIGHT.route) { from ->
        WidgetUI(modifier,onSnackSelected,from)
    }
    composable(DemoHomeSections.FUNC.route) { from ->
        FuncUI(modifier,onSnackSelected,from)
    }
    composable(DemoHomeSections.NETWORK.route) { from ->
        NetWorkUI(modifier)
    }
    composable(DemoHomeSections.OTHER.route) {
        otherUI(modifier)
    }
}



@Composable
fun NetWorkUI(modifier: Modifier) {
    Surface(modifier = modifier.fillMaxSize()) {
        Text(text = "网络", modifier =modifier.wrapContentSize() )
    }

}

@Composable
fun otherUI(modifier: Modifier) {
     MineScreen()
}