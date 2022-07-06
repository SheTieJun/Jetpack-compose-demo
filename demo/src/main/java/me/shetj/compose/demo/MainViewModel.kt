package me.shetj.compose.demo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import me.shetj.compose.demo.ui.home.fun_netwrok.paging.ExamplePagingSource

/**
 *
 * <b>@author：</b> shetj<br>
 * <b>@createTime：</b> 2022/6/10<br>
 * <b>@email：</b> 375105540@qq.com<br>
 * <b>@describe</b>  <br>
 */
class MainViewModel:ViewModel(){

    val listInfo = Pager(config = PagingConfig(
        pageSize = 20,
        initialLoadSize = 30,
        prefetchDistance = 2
    )){
        ExamplePagingSource()
    }.flow.cachedIn(viewModelScope)

}