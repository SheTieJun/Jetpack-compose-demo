package me.shetj.composekit.ui.theme

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController


/**
 *
```
Modifier.statusBarsPadding()
Modifier.navigationBarsPadding()
Modifier.systemBarsPadding()
Modifier.imePadding()
Modifier.navigationBarsWithImePadding()
Modifier.cutoutPadding()
```

```
Modifier.statusBarsHeight()
Modifier.navigationBarsHeight()
Modifier.navigationBarsWidth()
```
 */

@Composable
fun SystemUIController(action: SystemUiController.() ->Unit) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        action.invoke(systemUiController)
    }
}


@Composable
fun getContext(): Context {
    return LocalContext.current
}