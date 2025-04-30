package pe.isil.agenda

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun ContactDetail(
    modifier: Modifier = Modifier,
    contact: String? = null,
    onSave: (String) -> Unit = {}
) {

    val name = remember {
        mutableStateOf(contact ?: "")
    }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onSave(name.value)
                }
            ) {
                Icon(Icons.Default.Done, contentDescription = null)
            }
        }
    ) { padding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                placeholder = {
                    Text("Name")
                },
                value = name.value,
                onValueChange = {
                    name.value = it
                }
            )
        }
    }
}