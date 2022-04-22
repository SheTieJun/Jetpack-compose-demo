package me.shetj.compose.demo.model

import androidx.compose.runtime.Immutable
import me.shetj.compose.demo.model.WeightRepo.keyId

/**
 *
 * <b>@author：</b> shetj<br>
 * <b>@createTime：</b> 2022/4/15<br>
 * <b>@email：</b> 375105540@qq.com<br>
 * <b>@describe</b>  <br>
 */
object WeightRepo {

    fun getWeights() = weightCollection

    var keyId = 0L
}


//不可变
@Immutable
data class WeightModel(
    val id: Long,
    val name: String,
)

private val images = WeightModel(
    id = keyId++,
    name = "Images",
)


private val button = WeightModel(
    id = keyId++,
    name = "Buttons",
)


private val bottomappbar = button.copy(
    id = keyId++,
    name = "BottomAppBar",
)


private val Cards = button.copy(
    id = keyId++,
    name = "Cards",
)

private val menus = button.copy(
    id = keyId++,
    name = "Menus",
)

private val checkboxes = button.copy(
    id = keyId++,
    name = "Checkboxes",
)

private val dialogs = button.copy(
    id = keyId++,
    name = "Dialogs",
)

private val progressindicators = button.copy(
    id = keyId++,
    name = "ProgressIndicators",
)

private val tabs = button.copy(
    id = keyId++,
    name = "Tabs",
)

private val sliders = button.copy(
    id = keyId++,
    name = "Sliders",
)


private val badges = button.copy(
    id = keyId++,
    name = "Badges",
)


private val textfields = button.copy(
    id = keyId++,
    name = "TextFields",
)

private val topappbar = button.copy(
    id = keyId++,
    name = "TopAppBar",
)

private val NavigationDrawer = button.copy(
    id = keyId++,
    name = "NavigationDrawer",
)

val weightCollection = listOf(
    images,
    button,
    bottomappbar,
    topappbar,
    Cards,
    menus,
    dialogs,
    progressindicators,
    tabs,
    sliders,
    badges,
    checkboxes,
    textfields,
    NavigationDrawer
)