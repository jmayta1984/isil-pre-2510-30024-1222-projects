package pe.isil.agenda

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Preview
@Composable
fun Home() {
    val navController = rememberNavController()

    val contacts = remember {
        mutableStateOf(emptyList<String>())
    }
    val selectedContact = remember {
        mutableStateOf<String?>(null)
    }

    NavHost(
        navController = navController,
        startDestination = "ContactList"
    ) {
        composable("ContactList") {
            ContactList(
                contacts = contacts.value,
                onAdd = {
                    selectedContact.value = null
                    navController.navigate(route = "ContactDetail")
                },
                onDelete = { contact ->
                    contacts.value = contacts.value.filterNot { it == contact }
                },
                onSelect = { contact ->
                    selectedContact.value = contact
                    navController.navigate(route = "ContactDetail")
                }

            )
        }
        composable("ContactDetail") {
            ContactDetail(contact = selectedContact.value) { contact ->
                if (selectedContact.value == null) {
                    contacts.value += contact
                } else {
                    contacts.value = contacts.value.map { it ->
                        if (it == selectedContact.value) contact else it
                    }
                }
                navController.popBackStack()
            }
        }
    }
}