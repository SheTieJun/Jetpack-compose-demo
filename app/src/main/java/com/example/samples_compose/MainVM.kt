package com.example.samples_compose

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flow

/**
 *
 * <b>@author：</b> shetj<br>
 * <b>@createTime：</b> 2021/12/20<br>
 * <b>@email：</b> 375105540@qq.com<br>
 * <b>@describe</b>  <br>
 */
class MainVM: ViewModel() {

    var isRefresh: MutableSharedFlow<Boolean> = MutableSharedFlow()
}