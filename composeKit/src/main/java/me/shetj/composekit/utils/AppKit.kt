package me.shetj.composekit.utils

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.lifecycle.MutableLiveData
import me.shetj.composekit.ui.theme.AppTheme
import me.shetj.composekit.ui.theme.AppTheme.DynamicLight
import me.shetj.composekit.ui.theme.getContext

@Composable
fun ShowToast(string: String) {
    Toast.makeText(getContext(), string, Toast.LENGTH_SHORT).show()
}

fun Context.showToast(string: String) {
    Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
}

fun String.log(){
    Log.i("ComposeKit",this)
}

var isDark: MutableLiveData<Boolean> = MutableLiveData()

var appTheme: MutableLiveData<AppTheme> = MutableLiveData(DynamicLight)