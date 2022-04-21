package me.shetj.compose.demo.model

import androidx.compose.runtime.Immutable

/**
 *
 * <b>@author：</b> shetj<br>
 * <b>@createTime：</b> 2022/4/15<br>
 * <b>@email：</b> 375105540@qq.com<br>
 * <b>@describe</b>  <br>
 */
object WeightRepo {

    fun getWeights() = weightCollection

}


//不可变
@Immutable
data class WeightModel(
    val id: Long,
    val name: String,
)

private val images = WeightModel(
    id = 0L,
    name = "Images",
)


private val button = WeightModel(
    id = 1L,
    name = "Buttons",
)


private val bottomappbar = button.copy(
    id = 2L,
    name = "BottomAppBar",
)



private val Cards = button.copy(
    id = 3L,
    name = "Cards",
)

private val menus = button.copy(
    id = 4L,
    name = "Menus",
)

private val checkboxes = button.copy(
    id = 5L,
    name = "Checkboxes",
)

private val dialogs = button.copy(
    id = 6L,
    name = "Dialogs",
)

private val progressindicators = button.copy(
    id = 7L,
    name = "ProgressIndicators",
)

private val tabs = button.copy(
    id = 8L,
    name = "Tabs",
)

private val sliders = button.copy(
    id = 9L,
    name = "Sliders",
)


private val fab = button.copy(
    id = 10L,
    name = "FAB",
)

private val badges = button.copy(
    id = 11L,
    name = "Badges",
)

private val navigationbar = button.copy(
    id = 12L,
    name = "NavigationBar",
)

private val radiobuttons = button.copy(
    id = 13L,
    name = "RadioButtons",
)

private val textfields = button.copy(
    id = 14L,
    name = "TextFields",
)

private val topappbar = button.copy(
    id = 15L,
    name = "TopAppBar",
)

private val NavigationDrawer = button.copy(
    id = 16L,
    name = "NavigationDrawer",
)

val weightCollection = listOf(
    images,
    button,
    bottomappbar,
    topappbar,
    Cards,
    menus,
    navigationbar,
    dialogs,
    progressindicators,
    tabs,
    sliders,
    badges,
    radiobuttons,
    checkboxes,
    fab,
    textfields,
    NavigationDrawer
)