package ro.alingrosu.aviv.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ro.alingrosu.aviv.presentation.ui.theme.AvivTheme
import ro.alingrosu.aviv.presentation.navigation.AppNavHost

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AvivTheme {
                AppNavHost(navController = rememberNavController())
            }
        }
    }
}