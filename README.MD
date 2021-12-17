## Accompanist

[https://google.github.io/accompanist/](https://google.github.io/accompanist/)


### 📐 [Insets](./insets/)
A library that brings [WindowInsets][windowinsets] support to Jetpack Compose.

```
ProvideWindowInsets
```
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


### 🍫 [System UI Controller](./systemuicontroller/)
A library that provides easy-to-use utilities for recoloring the Android system bars from Jetpack Compose.

### 🎨 [AppCompat Theme Adapter](./appcompat-theme/)
A library that enables the reuse of [AppCompat][appcompat] XML themes for theming in Jetpack Compose.

### 📖 [Pager](./pager/)
A library that provides utilities for building paginated layouts in Jetpack Compose, similar to Android's [ViewPager][viewpager].

### 📫 [Permissions](./permissions/)
A library that provides [Android runtime permissions][runtimepermissions] support for Jetpack Compose.

### ⏳ [Placeholder](./placeholder/)
A library that provides easy-to-use modifiers for displaying a placeholder UI while content is loading.



### 🌊 [Flow Layouts](./flowlayout/)
A library that adds Flexbox-like layout components to Jetpack Compose.

```
FlowRow {
    // row contents
}

FlowColumn {
    // column contents
}
```

### 🧭✨[Navigation-Animation](./navigation-animation/)
A library which provides [Compose Animation](https://developer.android.com/jetpack/compose/animation) support for Jetpack Navigation Compose.

### 🧭🎨️ [Navigation-Material](./navigation-material/)
A library which provides [Compose Material](https://developer.android.com/jetpack/androidx/releases/compose-material) support, such as modal bottom sheets, for Jetpack Navigation Compose.

### 🖌️ [Drawable Painter](./drawablepainter/)
A library which provides a way to use Android Drawables as Jetpack Compose Painters.

```
   val drawable = AppCompatResources.getDrawable(LocalContext.current, R.drawable.rectangle)

    Image(
        painter = rememberDrawablePainter(drawable = drawable),
        contentDescription = "content description",
    )
```

### ⬇️ [Swipe to Refresh](./swiperefresh/)
A library that provides a layout implementing the swipe-to-refresh UX pattern, similar to Android's [SwipeRefreshLayout](https://developer.android.com/jetpack/androidx/releases/swiperefreshlayout).


## material3
https://m3.material.io/