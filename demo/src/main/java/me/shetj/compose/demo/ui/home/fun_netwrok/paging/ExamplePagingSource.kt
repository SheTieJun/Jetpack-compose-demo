package me.shetj.compose.demo.ui.home.fun_netwrok.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import me.shetj.compose.demo.ui.home.fun_netwrok.model.UserInfo

/**
 *
 * <b>@author：</b> shetj<br>
 * <b>@createTime：</b> 2022/6/10<br>
 * <b>@email：</b> 375105540@qq.com<br>
 * <b>@describe</b>  <br>
 */
class ExamplePagingSource : PagingSource<Int, UserInfo>() {

    override fun getRefreshKey(state: PagingState<Int, UserInfo>): Int? {

        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }


    /**
     * PagingState：包含到目前为止已加载的页面、最近访问的索引以及用于初始化分页数据流的 PagingConfig 对象的相关信息。
     * LoadType：指示加载的类型：REFRESH、APPEND 或 PREPEND。
     */
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserInfo> {
        return try {
            // Start refresh at page 1 if undefined.
            val nextPageNumber = params.key ?: 1
            LoadResult.Page(
                data = UserInfo.mockList(nextPageNumber, params.loadSize),
                prevKey = null, // Only paging forward.
                nextKey = nextPageNumber + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}