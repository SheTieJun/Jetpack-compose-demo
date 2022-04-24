package me.shetj.compose.demo.ui.home

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.NetworkCheck
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.NetworkCheck
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import me.shetj.compose.demo.DemoDestinations
import me.shetj.compose.demo.R
import me.shetj.compose.demo.ui.home.DemoHomeSections.NETWORK

enum class DemoHomeSections(
    @StringRes val title: Int,
    val icon: ImageVector,
    val selectIcon:ImageVector,
    val route: String
) {
    WEIGHT(R.string.home_feed, Icons.Outlined.Home,Icons.Filled.Home,  "home/${DemoDestinations.WEIGHT_ROUTE}"),
    FUNC(R.string.home_func, Icons.Outlined.ShoppingCart,  Icons.Filled.ShoppingCart, "home/${DemoDestinations.FUNC_ROUTE}"),
    NETWORK(R.string.home_net, Icons.Outlined.NetworkCheck, Icons.Filled.NetworkCheck, "home/${DemoDestinations.NETWORK_ROUTER}"),
    OTHER(R.string.home_other, Icons.Outlined.AccountCircle, Icons.Filled.AccountCircle, "home/${DemoDestinations.OTHER_ROUTER}")
}

fun DemoHomeSections.isNewWork() = route == NETWORK.route


const val BASE_WEIGHT_ROUTER = "home/${DemoDestinations.WEIGHT_ROUTE}"

const val BASE_FUNC_ROUTER = "home/${DemoDestinations.FUNC_ROUTE}"

enum class DemoWeightSections(
    @StringRes val title: Int,
    val icon: ImageVector,
    val selectIcon:ImageVector,
    val route: String
) {
    IMAGES(R.string.home_feed, Icons.Outlined.Home,Icons.Filled.Home,  "home/${DemoDestinations.WEIGHT_ROUTE}/Images"),
    BUTTON(R.string.home_feed, Icons.Outlined.Home,Icons.Filled.Home,  "home/${DemoDestinations.WEIGHT_ROUTE}/Buttons"),
    CARDS(R.string.home_feed, Icons.Outlined.Home,Icons.Filled.Home,  "home/${DemoDestinations.WEIGHT_ROUTE}/Cards"),
    BOTTOMAPPBAR(R.string.home_feed, Icons.Outlined.Home,Icons.Filled.Home,  "home/${DemoDestinations.WEIGHT_ROUTE}/BottomAppBar"),
    TOPAPPBAR(R.string.home_feed, Icons.Outlined.Home,Icons.Filled.Home,  "home/${DemoDestinations.WEIGHT_ROUTE}/TopAppBar"),
    MENUS(R.string.home_feed, Icons.Outlined.Home,Icons.Filled.Home,  "home/${DemoDestinations.WEIGHT_ROUTE}/Menus"),
    PROGRESSINDICATORS(R.string.home_feed, Icons.Outlined.Home,Icons.Filled.Home,  "home/${DemoDestinations.WEIGHT_ROUTE}/ProgressIndicators"),
    Tabs(R.string.home_feed, Icons.Outlined.Home,Icons.Filled.Home,  "home/${DemoDestinations.WEIGHT_ROUTE}/Tabs"),
    Sliders(R.string.home_feed, Icons.Outlined.Home,Icons.Filled.Home,  "home/${DemoDestinations.WEIGHT_ROUTE}/Sliders"),
    Checkboxes(R.string.home_feed, Icons.Outlined.Home,Icons.Filled.Home,  "home/${DemoDestinations.WEIGHT_ROUTE}/Checkboxes"),
    TextFields(R.string.home_feed, Icons.Outlined.Home,Icons.Filled.Home,  "home/${DemoDestinations.WEIGHT_ROUTE}/TextFields"),
    NavigationDrawer(R.string.home_feed, Icons.Outlined.Home,Icons.Filled.Home,  "home/${DemoDestinations.WEIGHT_ROUTE}/NavigationDrawer"),
}


enum class DemoFuncSections(
    @StringRes val title: Int,
    val icon: ImageVector,
    val selectIcon:ImageVector,
    val route: String
) {
    WebView(R.string.home_feed, Icons.Outlined.Home,Icons.Filled.Home,  "$BASE_FUNC_ROUTER/WebView"),
}