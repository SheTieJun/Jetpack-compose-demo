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
import me.shetj.compose.demo.ui.home_weight.WidgetUI

@ExperimentalMaterial3Api
fun NavGraphBuilder.addHomeGraph(
    onSnackSelected: (Long, NavBackStackEntry) -> Unit,
    modifier: Modifier = Modifier
) {
    composable(DemoHomeSections.WEIGHT.route) { from ->
        WidgetUI(modifier)
    }
    composable(DemoHomeSections.FUNC.route) { from ->
        FuncUI(modifier)
    }
    composable(DemoHomeSections.NETWORK.route) { from ->
        NetWorkUI(modifier)
    }
    composable(DemoHomeSections.OTHER.route) {
        otherUI(modifier)
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FuncUI(modifier: Modifier) {
    Surface(modifier = modifier.fillMaxSize()) {
        Text(text = "功能", modifier = modifier.wrapContentSize())
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NetWorkUI(modifier: Modifier) {
    Surface(modifier = modifier.fillMaxSize()) {
        Text(text = "网络", modifier =modifier.wrapContentSize() )
    }

}

@Composable
fun otherUI(modifier: Modifier) {
    Surface(modifier = modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .wrapContentSize()
                .padding(24.dp)
        ) {
            Spacer(Modifier.height(24.dp))
            Text(
                text = "其他",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = "其他",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}