package com.example.samples_compose

import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow

/**
 *
 * <b>@author：</b> shetj<br>
 * <b>@createTime：</b> 2021/12/20<br>
 * <b>@email：</b> 375105540@qq.com<br>
 * <b>@describe</b>  <br>
 */
class MainVM : ViewModel() {

    //需要 remember { isRefresh.collectAsState(false) }
    var isRefresh: MutableSharedFlow<Boolean> = MutableSharedFlow()

    fun getNightModel(): Int {
        //主题背景属性 ?attr/colorSurface 和 ?attr/colorOnSurface）轻松获取合适的颜色
        //浅色 - MODE_NIGHT_NO
        //深色 - MODE_NIGHT_YES
        //由省电模式设置 - MODE_NIGHT_AUTO_BATTERY
        //系统默认 - MODE_NIGHT_FOLLOW_SYSTEM
        val defaultNightMode = AppCompatDelegate.getDefaultNightMode()

        if (defaultNightMode == AppCompatDelegate.MODE_NIGHT_NO) {
            return AppCompatDelegate.MODE_NIGHT_YES
        }
        if (defaultNightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            return AppCompatDelegate.MODE_NIGHT_NO
        }
        return AppCompatDelegate.MODE_NIGHT_YES
    }
}