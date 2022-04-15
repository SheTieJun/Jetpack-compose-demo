package me.shetj.compose.demo.model

import androidx.lifecycle.MutableLiveData

/**
 * 红点控制
 */
object BadgesManager {


    val netBadgesLiveData get() = MutableLiveData(0)


    fun addBadges() {
        netBadgesLiveData.postValue((netBadgesLiveData.value ?: 0) + 1)
    }

    fun cleanBadges() {
        netBadgesLiveData.postValue(0)
    }

}


