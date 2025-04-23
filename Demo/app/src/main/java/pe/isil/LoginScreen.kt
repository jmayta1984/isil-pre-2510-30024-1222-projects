package pe.isil

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun LoginScreen(){

    val username = remember {
        mutableStateOf("")
    }

    val password = remember {
        mutableStateOf("")
    }
    val isVisible = remember {
        mutableStateOf(false)
    }

    Scaffold{ paddingValues ->
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize().padding(paddingValues)
            ) {
            OutlinedTextField(
                value = username.value,
                onValueChange = {
                    username.value = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                placeholder = {
                    Text("Username")
                },
                trailingIcon = {
                    Icon(Icons.Default.Person, contentDescription = null)
                }
            )
            OutlinedTextField(
                value = password.value,
                onValueChange = {
                    password.value = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                placeholder = {
                    Text("Password")
                },
                trailingIcon = {
                    IconButton(
                        onClick = {
                            isVisible.value = !isVisible.value
                        }
                    ) {
                        Icon(
                            if (isVisible.value) {
                                Icons.Default.Visibility

                            } else {
                                Icons.Default.VisibilityOff
                            }
                            ,
                            contentDescription = null)

                    }

                },
                visualTransformation = if (isVisible.value) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                }

            )

        }
    }

}
