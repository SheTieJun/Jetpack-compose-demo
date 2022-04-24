package me.shetj.compose.demo.ui.home_weight

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.RadioButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.Icons.Outlined
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonUI(modifier: Modifier = Modifier) {

    Scaffold(modifier = modifier,
        topBar = {
            DemoTopBar("Buttons")
        }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 15.dp)
        ) {

            item {
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
            }
            //2. 圆角image

            item {
                IconButton()
            }
            item {
                Fab()

                RadioButtonUI()

                SwitchSample()
            }
        }
    }
}

@Composable
private fun IconButton() {
    Spacer(Modifier.size(26.dp))
    Text(text = "Fab", style = MaterialTheme.typography.titleLarge)
    Spacer(Modifier.size(10.dp))
    Divider()
    Row() {

        IconButton(onClick = { /* doSomething() */ }) {
            Icon(Outlined.Lock, contentDescription = "Localized description")
        }
        Spacer(Modifier.size(16.dp))
        IconToggleButtonSample()
    }
}


@Composable
fun IconToggleButtonSample() {
    var checked by remember { mutableStateOf(false) }
    IconToggleButton(checked = checked, onCheckedChange = { checked = it }) {
        if (checked) {
            Icon(Icons.Filled.Lock, contentDescription = "Localized description")
        } else {
            Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
        }
    }
}


@Composable
private fun Fab() {
    Spacer(Modifier.size(26.dp))
    Text(text = "Fab", style = MaterialTheme.typography.titleLarge)
    Spacer(Modifier.size(10.dp))
    Divider()
    Spacer(Modifier.size(10.dp))
    Row(Modifier.padding(10.dp, 0.dp, 10.dp, 0.dp)) {
        FloatingActionButton(
            onClick = { /* do something */ },
        ) {
            Icon(Filled.Add, "Localized description")
        }

        Spacer(Modifier.size(16.dp))


        SmallFloatingActionButton(
            onClick = { /* do something */ },
        ) {
            Icon(Filled.Add, contentDescription = "Localized description")
        }

        Spacer(Modifier.size(16.dp))
        LargeFloatingActionButton(
            onClick = { /* do something */ },
        ) {
            Icon(
                Filled.Add,
                contentDescription = "Localized description",
                modifier = Modifier.size(FloatingActionButtonDefaults.LargeIconSize),
            )
        }
    }
}

@Composable
private fun RadioButtonUI() {
    Spacer(Modifier.size(26.dp))
    Text(text = "RadioButton", style = MaterialTheme.typography.titleLarge)
    Spacer(Modifier.size(10.dp))
    Divider()
    Spacer(Modifier.size(10.dp))
    Row(Modifier.padding(10.dp, 0.dp, 10.dp, 0.dp)) {
        var state by remember { mutableStateOf(true) }
        Row(Modifier.selectableGroup()) {
            RadioButton(
                selected = state,
                onClick = { state = true }
            )
            RadioButton(
                selected = !state,
                onClick = { state = false }
            )
        }
    }
}

@Composable
fun SwitchSample() {
    Spacer(Modifier.size(26.dp))
    Text(text = "Switch", style = MaterialTheme.typography.titleLarge)
    Spacer(Modifier.size(10.dp))
    Divider()
    var checked by remember { mutableStateOf(true) }
    Switch(checked = checked, onCheckedChange = { checked = it })
}
