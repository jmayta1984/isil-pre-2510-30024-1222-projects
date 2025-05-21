package pe.isil.easypizza

import androidx.compose.material3.Text
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

    var createdOrder = remember {
        mutableStateOf<Order?>(null)
    }
    NavHost(navController, startDestination = "order") {

        composable("order")
        {
            OrderView { order ->
                createdOrder.value = order
                navController.navigate("confirmation")
            }
        }


        composable("confirmation")
        {
            createdOrder.value?.let {
                Text(it.size)
            }
        }

    }
}