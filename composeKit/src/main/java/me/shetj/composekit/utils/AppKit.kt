package me.shetj.composekit.utils

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import me.shetj.composekit.ui.theme.getContext

@Composable
fun ShowToast(string: String) {
    Toast.makeText(getContext(), string, Toast.LENGTH_SHORT).show()
}

fun Context.showToast(string: String) {
    Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
}