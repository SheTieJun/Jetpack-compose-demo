package me.shetj.compose.demo

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.navigation
import me.shetj.compose.demo.ui.components.BottomBar
import me.shetj.compose.demo.ui.home.DemoHomeSections
import me.shetj.compose.demo.ui.home.addHomeGraph
import me.shetj.composekit.ui.theme.DefTheme
import me.shetj.composekit.ui.weight.DemoSnackbar
import me.shetj.composekit.utils.isDark

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DemoApp() {



    //用来切换暗黑模式
    val isDarkModel: Boolean by isDark.observeAsState(isSystemInDarkTheme())

    DefTheme(isDarkModel) {
        // A surface container using the 'background' color from the theme
        val appState = rememberDemoAppState()
        appState.systemUiController.statusBarDarkContentEnabled = !isDarkModel

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
        route = DemoDestinations.HOME,
        startDestination = DemoHomeSections.WEIGHT.route
    ) {
        addHomeGraph(onSnackSelected)
    }
}

