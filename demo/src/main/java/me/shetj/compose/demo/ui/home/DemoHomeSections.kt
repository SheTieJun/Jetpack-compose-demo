package me.shetj.compose.demo.ui.home

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.NetworkCheck
import androidx.compose.material.icons.filled.NetworkWifi
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.NetworkCheck
import androidx.compose.material.icons.outlined.NetworkWifi
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import me.shetj.compose.demo.DemoDestinations
import me.shetj.compose.demo.R

enum class DemoHomeSections(
    @StringRes val title: Int,
    val icon: ImageVector,
    val selectIcon:ImageVector,
    val route: String
) {
    WIDGET(R.string.home_feed, Icons.Outlined.Home,Icons.Filled.Home,  "home/${DemoDestinations.WIDGET_ROUTE}"),
    FUNC(R.string.home_func, Icons.Outlined.ShoppingCart,  Icons.Filled.ShoppingCart, "home/${DemoDestinations.FUNC_ROUTE}"),
    NETWORK(R.string.home_net, Icons.Outlined.NetworkCheck, Icons.Filled.NetworkCheck, "home/${DemoDestinations.NETWORK_ROUTER}"),
    OTHER(R.string.home_other, Icons.Outlined.AccountCircle, Icons.Filled.AccountCircle, "home/${DemoDestinations.OTHER_ROUTER}")
}