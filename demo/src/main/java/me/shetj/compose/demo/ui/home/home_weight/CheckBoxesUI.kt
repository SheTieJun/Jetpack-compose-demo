package me.shetj.compose.demo.ui.home.home_weight

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckBoxesUI(modifier: Modifier = Modifier) {

    Scaffold(modifier = modifier,
        topBar = {
            DemoTopBar("CheckBoxes")
        }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 15.dp)
        ) {


            Row(verticalAlignment = Alignment.CenterVertically) {

                val checkedState = remember { mutableStateOf(true) }

                Checkbox(
                    checked = checkedState.value,
                    onCheckedChange = { checkedState.value = it }
                )

                Text(text = "CheckBox")
            }

            Spacer(Modifier.size(25.dp))

            Column {
                // define dependent checkboxes states
                val (state, onStateChange) = remember { mutableStateOf(true) }
                val (state2, onStateChange2) = remember { mutableStateOf(true) }

                // TriStateCheckbox state reflects state of dependent checkboxes
                val parentState = remember(state, state2) {
                    if (state && state2) ToggleableState.On
                    else if (!state && !state2) ToggleableState.Off
                    else ToggleableState.Indeterminate
                }
                // click on TriStateCheckbox can set state for dependent checkboxes
                val onParentClick = {
                    val s = parentState != ToggleableState.On
                    onStateChange(s)
                    onStateChange2(s)
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    TriStateCheckbox(
                        state = parentState,
                        onClick = onParentClick,
                    )
                    Text(text = "CheckBox 1 & 2")
                }
                Spacer(Modifier.size(5.dp))

                Column(Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp)) {

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(state, onStateChange)
                        Text(text = "CheckBox 1 ")
                    }

                    Spacer(Modifier.size(5.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(state2, onStateChange2)
                        Text(text = "CheckBox 2 ")
                    }
                }
            }
        }
    }
}