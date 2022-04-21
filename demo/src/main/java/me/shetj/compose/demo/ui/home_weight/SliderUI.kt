package me.shetj.compose.demo.ui.home_weight

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SliderUI(modifier: Modifier = Modifier) {
    var sliderPosition by remember { mutableStateOf(0f) }

    var sliderPosition2 by remember { mutableStateOf(0f) }

    Scaffold(modifier = modifier,
        topBar = {
            DemoTopBar("Slider")
        }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 15.dp)
        ) {

            Column {
                Text(text = sliderPosition.toString())
                Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
            }

            Spacer(Modifier.height(16.dp))

            Column {
                Text(text = sliderPosition2.toInt().toString())
                Slider(
                    value = sliderPosition2,
                    onValueChange = { sliderPosition2 = it },
                    valueRange = 0f..100f,
                    onValueChangeFinished = {
                        // launch some business logic update with the state you hold
                        // viewModel.updateSelectedSliderValue(sliderPosition)
                    },
                    steps = 4
                )
            }

        }
    }
}