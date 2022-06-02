package me.shetj.compose.demo.ui.home.home_func

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate

@Composable
fun CanvasScreen() {
    Canvas(modifier = Modifier.fillMaxSize()) {

        val canvasWidth = size.width
        val canvasHeight = size.height

        drawLine(
            start = Offset(x = canvasWidth, y = 0f),
            end = Offset(x = 0f, y = canvasHeight),
            color = Color.Blue
        )

        drawCircle(
            color = Color.Blue,
            center = Offset(x = size.minDimension / 2, y =size.minDimension / 2),
            radius = size.minDimension / 4
        )

        drawRect(
            color = Color.Red,
            topLeft = Offset(x = canvasWidth / 3F, y = canvasHeight / 3F),
            size = size / 3F
        )

        drawArc(color = Color.Yellow, startAngle = 20f
        , sweepAngle = 180f, useCenter = true,
            topLeft = Offset(x = size.minDimension / 3, y =size.minDimension / 3), size = size / 4F
        )

        rotate(45f){
            drawRect(
                color = Color.Gray,
                topLeft = Offset(x = canvasWidth / 3F, y = canvasHeight / 3F),
                size = size / 3F
            )
        }
    }
}