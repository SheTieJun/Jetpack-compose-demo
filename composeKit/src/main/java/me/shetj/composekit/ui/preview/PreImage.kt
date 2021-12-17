package me.shetj.composekit.ui.preview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import me.shetj.composekit.R.drawable
import me.shetj.composekit.ui.theme.YellowTheme
import me.shetj.composekit.ui.weight.CirImage
import me.shetj.composekit.ui.weight.LocalImage

@Preview(showBackground = true)
@Composable
fun preImage(){

    YellowTheme {
        Column {
            Image(
                painter = painterResource(id =  drawable.cathedral_rock),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            CirImage(res = drawable.cathedral_rock )
            LocalImage(res = drawable.cathedral_rock)
        }
    }
}