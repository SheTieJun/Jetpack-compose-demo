package me.shetj.compose.demo.ui.home.fun_netwrok.model

/**
 *
 * <b>@author：</b> shetj<br>
 * <b>@createTime：</b> 2022/6/10<br>
 * <b>@email：</b> 375105540@qq.com<br>
 * <b>@describe</b>  <br>
 */
class UserInfo(val name: String) {

    companion object {

        fun mockList(page: Int, loadSize: Int): List<UserInfo> {
            return buildList<UserInfo> {
                repeat(loadSize) {
                    add(UserInfo("page = $page : loadSize:$loadSize : repeat = $it"))
                }
            }
        }
    }
}