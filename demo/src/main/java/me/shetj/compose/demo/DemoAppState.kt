package me.shetj.compose.demo

import android.content.res.Resources
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import me.shetj.compose.demo.ui.home.DemoHomeSections
import me.shetj.composekit.model.SnackbarManager


object DemoDestinations {

    const val HOME = "home"

    const val WEIGHT_ROUTE = "Weight"
    const val FUNC_ROUTE = "Func"
    const val NETWORK_ROUTER = "NetWork"
    const val OTHER_ROUTER = "other"
}

/**
 * Remembers and creates an instance of [JetsnackAppState]
 */
@Composable
fun rememberDemoAppState(
    systemUiController: SystemUiController = rememberSystemUiController(),
    navController: NavHostController = rememberNavController(),
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState().apply {
    } },
    snackbarManager: SnackbarManager = SnackbarManager,
    resources: Resources = resources(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) =
    remember(systemUiController, navController, snackbarHostState, snackbarManager, resources, coroutineScope) {
        DemoAppState(
            systemUiController,
            navController,
            snackbarHostState,
            snackbarManager,
            resources,
            coroutineScope
        )
    }


//标记稳定
@Stable
class DemoAppState(
    val systemUiController: SystemUiController,
    val navController: NavHostController,
    val snackbarHostState: SnackbarHostState,
    private val snackbarManager: SnackbarManager,
    private val resources: Resources,
    val coroutineScope: CoroutineScope
) {

    init {
        statuInScreen()
        coroutineScope.launch {
            snackbarManager.messages.collect { currentMessages ->
                if (currentMessages.isNotEmpty()) {
                    val message = currentMessages[0]
                    val text = message.message
                    snackbarHostState.showSnackbar(text,
                        withDismissAction = true)
                    snackbarManager.setMessageShown(message.id)
                }
            }
        }
    }

//region  路由相关


    val bottomBarTabs = DemoHomeSections.values()
    private val bottomBarRoutes = bottomBarTabs.map { it.route }

    // Reading this attribute will cause recompositions when the bottom bar needs shown, or not.
    // Not all routes need to show the bottom bar.
    val shouldShowBottomBar: Boolean
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination?.route in bottomBarRoutes

    val currentRoute: String?
        get() = navController.currentDestination?.route

    /**
     * 路由处理
     */
    fun navigateToBottomBarRoute(route: String) {
        if (route != currentRoute) {
            navController.navigate(route) {
                launchSingleTop = true
                restoreState = true
                // Pop up backstack to the first destination and save state. This makes going back
                // to the start destination when pressing back in any other bottom tab.
                popUpTo(findStartDestination(navController.graph).id) {
                    saveState = true
                }
            }
        }
    }

    fun navigateByRouter(route: String, from: NavBackStackEntry) {
        // In order to discard duplicated navigation events, we check the Lifecycle
        if (from.lifecycleIsResumed()) {
            navController.navigate(route) {
                launchSingleTop = true
            }
        }
    }

    fun upPress() {
        //返回上一次
        navController.navigateUp()
    }

    //endregion


    fun statuInScreen() {
        systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = true)
    }


}

private fun NavBackStackEntry.lifecycleIsResumed() =
    this.lifecycle.currentState == Lifecycle.State.RESUMED

private val NavGraph.startDestination: NavDestination?
    get() = findNode(startDestinationId)

private tailrec fun findStartDestination(graph: NavDestination): NavDestination {
    return if (graph is NavGraph) findStartDestination(graph.startDestination!!) else graph
}


@Composable
@ReadOnlyComposable
private fun resources(): Resources {
    LocalConfiguration.current
    return LocalContext.current.resources
}