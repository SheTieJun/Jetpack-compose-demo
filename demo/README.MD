## demo 中用到的控件


1. - [X] NavigationBar
```kotlin
    var selectedItem by remember { mutableStateOf(0) }

    val items = listOf("Favorite", "Artists", "Playlists")

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    BadgedBox(badge = { Badge { Text("8") } }) {
                        Icon(
                            if (selectedItem == index) Icons.Filled.Star else Icons.TwoTone.Star,
                            contentDescription = "Favorite"
                        )
                    }
                },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index },
                colors = NavigationBarItemDefaults.colors(indicatorColor =  MaterialTheme.colorScheme.primaryContainer),
                alwaysShowLabel = true
            )
        }
    }
```   
具体是配合
```kotlin
  BlueTheme {
    Scaffold(
        modifier = Modifier.fillMaxHeight().fillMaxWidth(), 
        contentColor = MaterialTheme.colorScheme.background, 
        bottomBar = { 
            Navigation() 
        }
    ) {
        
    } 
  }
```

2. - [X] 状态栏控制
```kotlin
//设置顶部透明，icon 黑色
val systemUiController = rememberSystemUiController()
systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = true)
```

