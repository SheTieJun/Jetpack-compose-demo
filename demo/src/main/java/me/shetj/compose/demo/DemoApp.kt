package me.shetj.compose.demo

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.navigation
import me.shetj.compose.demo.ui.components.BottomBar
import me.shetj.compose.demo.ui.home.DemoHomeSections
import me.shetj.compose.demo.ui.home.addHomeGraph
import me.shetj.composekit.ui.theme.BlueTheme
import me.shetj.composekit.ui.weight.DemoSnackbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DemoApp() {

    val appState = rememberDemoAppState()

    BlueTheme {
        // A surface container using the 'background' color from the theme
        Scaffold(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentColor = MaterialTheme.colorScheme.errorContainer,
            bottomBar = {
                if (appState.shouldShowBottomBar) {
                    BottomBar(appState)  //底部
                }
            },
            snackbarHost = {
                SnackbarHost(
                    hostState = appState.snackbarHostState,
                    modifier = Modifier.systemBarsPadding(),
                    snackbar = { snackbarData -> DemoSnackbar(snackbarData) }
                )
            }
        ) { innerPaddingModifier ->
            //创建 NavHost
            NavHost(
                navController = appState.navController,
                startDestination = DemoDestinations.HOME,
                modifier = Modifier.padding(innerPaddingModifier)
            ) {
                DemoAppNavGraph(onSnackSelected = { long, stack ->

                }, upPress = appState::upPress)
            }
        }
    }
}


fun NavGraphBuilder.DemoAppNavGraph(
    onSnackSelected: (Long, NavBackStackEntry) -> Unit,
    upPress: () -> Unit
) {
    /**
     * 导航嵌套,home 下面[DemoHomeSections]
     */
    navigation(
        route =  DemoDestinations.HOME,
        startDestination = DemoHomeSections.WIDGET.route
    ) {
        addHomeGraph(onSnackSelected)
    }
}

