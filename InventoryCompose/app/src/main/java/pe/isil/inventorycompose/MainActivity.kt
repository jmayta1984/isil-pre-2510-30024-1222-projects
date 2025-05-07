package pe.isil.inventorycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import pe.isil.inventorycompose.presentation.view.Home
import pe.isil.inventorycompose.ui.theme.InventoryComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InventoryComposeTheme {
                Home()
            }
        }
    }
}

