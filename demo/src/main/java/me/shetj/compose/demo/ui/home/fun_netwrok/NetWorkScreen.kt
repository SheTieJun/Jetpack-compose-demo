package me.shetj.compose.demo.ui.home.fun_netwrok

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import java.io.IOException
import me.shetj.compose.demo.MainViewModel
import me.shetj.compose.demo.ui.home.fun_netwrok.model.UserInfo
import me.shetj.compose.demo.ui.home.home_weight.DemoTopBar


@ExperimentalMaterial3Api
@Composable
fun NetWorkScreen(modifier: Modifier = Modifier, viewModel: MainViewModel) {

    val pagingItems = viewModel.listInfo.collectAsLazyPagingItems()
    val TAG = "加载状态"
    Scaffold(modifier = modifier.fillMaxSize(),
        topBar = {
            DemoTopBar("Paging3")
        }) { padding ->

        val refreshState = rememberSwipeRefreshState(isRefreshing = false)

        SwipeRefresh(state = refreshState, onRefresh = {
            pagingItems.refresh()
        }) {
            LazyColumn() {
                items(pagingItems, key = { item -> item.name })
                { value: UserInfo? ->
                    Text(text = value?.name ?: "错误数据")
                }


//                val append = pagingItems.loadState.append
//                val refresh = pagingItems.loadState.refresh

                if (pagingItems.loadState.refresh is LoadState.Loading) {
                    Log.d(TAG, "正在加载")
                } else if (pagingItems.loadState.refresh is LoadState.Error) {
                    when ((pagingItems.loadState.refresh as LoadState.Error).error) {
                        is IOException -> {
                            Log.d(TAG, "网络未连接，可在这里放置失败视图")
                        }
                        else -> {
                            Log.d(TAG, "网络未连接，其他异常")
                        }
                    }
                }

            }
        }
    }

}