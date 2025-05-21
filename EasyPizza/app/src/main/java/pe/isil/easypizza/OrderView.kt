package pe.isil.easypizza

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun OrderView(
    onConfirm: (Order) -> Unit = {}

){
    val sizes = listOf("Pequeña", "Mediana", "Grande")
    val selectedSize = remember {
        mutableStateOf("Pequeña")
    }
    val expanded = remember {
        mutableStateOf(false)
    }

    val hasOlives = remember {
        mutableStateOf(false)
    }


    Scaffold { padding ->
        Column (
            modifier =  Modifier.fillMaxSize().padding(padding),
            verticalArrangement = Arrangement.Center) {
            Box {
                Row (verticalAlignment = Alignment.CenterVertically) {
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = selectedSize.value,
                        onValueChange =  {},
                        readOnly = true,
                        trailingIcon = {
                            IconButton(
                                onClick = {
                                    expanded.value = !expanded.value
                                }
                            ) {
                                Icon(
                                if (expanded.value)
                                    Icons.Default.KeyboardArrowUp else
                                    Icons.Default.KeyboardArrowDown,
                                    contentDescription = null)
                            }
                        }
                    )
                }

                DropdownMenu(
                    modifier = Modifier.fillMaxWidth(),
                    expanded = expanded.value,
                    onDismissRequest = { expanded.value = false}
                ) {
                    sizes.forEach { size ->
                        DropdownMenuItem(
                            modifier = Modifier.fillMaxWidth(),
                            text = { Text(size) },
                            onClick = {
                                selectedSize.value  = size
                                expanded.value = false
                            }
                        )
                    }
                }
            }

            Row (verticalAlignment = Alignment.CenterVertically){
                Checkbox(

                    checked = hasOlives.value,
                    onCheckedChange = {
                        hasOlives.value = it
                    }
                )
                Text("Aceitunas")
            }
            Row (verticalAlignment = Alignment.CenterVertically){
                Checkbox(

                    checked = hasOlives.value,
                    onCheckedChange = {
                        hasOlives.value = it
                    }
                )
                Text("Cebollas")
            }
            Row (verticalAlignment = Alignment.CenterVertically){
                Checkbox(

                    checked = hasOlives.value,
                    onCheckedChange = {
                        hasOlives.value = it
                    }
                )
                Text("Tomate")
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    val order = Order(
                        size= selectedSize.value,
                        hasOlives = hasOlives.value)
                    onConfirm(order)
                }
            ) {
                Text("Confirmar")
            }


        }

    }
}


data class  Order (
    val size: String,
    val hasOlives: Boolean
)