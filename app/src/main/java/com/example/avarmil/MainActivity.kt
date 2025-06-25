package com.example.avarmil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.avarmil.ui.sections.start.StartDestination
import com.example.avarmil.ui.theme.AvarMilTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { AvarMilTheme { AverMilNavHost() } }
    }

    @Composable
    private fun AverMilNavHost() {
        NavHost(
            modifier = Modifier.fillMaxSize(),
            navController = rememberNavController(),
            startDestination = Destinations.Start,
            builder = {
                val composableModifier = Modifier.fillMaxSize()
                composable<Destinations.Start>(
                    content = {
                        StartDestination.Screen(
                            modifier = composableModifier
                        )
                    }
                )
            }
        )
    }
}

sealed class Destinations {
    @Serializable
    data object Start : Destinations()

}