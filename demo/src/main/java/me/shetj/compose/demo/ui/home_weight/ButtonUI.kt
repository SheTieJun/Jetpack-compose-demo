package me.shetj.compose.demo.ui.home_weight

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonUI(modifier: Modifier = Modifier) {

    Scaffold(modifier = modifier,
        topBar = {
            DemoTopBar("Buttons")
        }) {
        Column(modifier = Modifier.fillMaxSize().padding(start = 15.dp)) {

            //1. Button	M3 filled button
            Button(onClick = { /* Do something! */ }) { Text("Button") }
            Spacer(Modifier.height(16.dp))

            //2. ElevatedButton	M3 elevated button
            ElevatedButton(onClick = { /* Do something! */ }) { Text("Elevated Button") }
            Spacer(Modifier.height(16.dp))

            //3. FilledTonalButton	M3 filled tonal button
            FilledTonalButton(onClick = { /* Do something! */ }) { Text("Filled Tonal Button") }
            Spacer(Modifier.height(16.dp))

            //4. OutlinedButton	M3 outlined button
            OutlinedButton(onClick = { /* Do something! */ }) { Text("Outlined Button") }
            Spacer(Modifier.height(16.dp))
            //5. TextButton
            TextButton(onClick = { /* Do something! */ }) { Text("Text Button") }
            Spacer(Modifier.height(16.dp))
            //2. 圆角image

        }
    }
}