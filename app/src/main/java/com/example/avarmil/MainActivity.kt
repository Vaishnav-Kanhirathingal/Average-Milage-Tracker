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
import com.example.avarmil.ui.sections.home.HomeScreen
import com.example.avarmil.ui.sections.route_history.RouteHistoryScreen
import com.example.avarmil.ui.sections.start.StartScreen
import com.example.avarmil.ui.sections.view_route.ViewRouteScreen
import com.example.avarmil.ui.theme.AvarMilTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.Serializable

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { AvarMilTheme { AverMilNavHost() } }
    }

    @Composable
    private fun AverMilNavHost() {
        val navController = rememberNavController()
        NavHost(
            modifier = Modifier.fillMaxSize(),
            navController = navController,
            startDestination = Destinations.Start,
            builder = {
                val composableModifier = Modifier.fillMaxSize()
                composable<Destinations.Start>(
                    content = {
                        StartScreen.Screen(
                            modifier = composableModifier,
                            toHomeScreen = { navController.navigate(route = Destinations.Home) }
                        )
                    }
                )
                composable<Destinations.Home>(
                    content = { HomeScreen.Screen(modifier = composableModifier) }
                )
                composable<Destinations.RouteHistory>(
                    content = { RouteHistoryScreen.Screen(modifier = composableModifier) }
                )
                composable<Destinations.ViewRoute>(
                    content = {
                        val routeId = it.arguments?.getInt(Destinations.ViewRoute::routeId.name)
                        ViewRouteScreen.Screen(
                            modifier = Modifier
                        )
                        TODO("Use route id to get route details")
                    }
                )
            }
        )
    }
}

sealed class Destinations {
    @Serializable
    data object Start : Destinations()

    @Serializable
    data object Home : Destinations()

    @Serializable
    data object RouteHistory : Destinations()

    @Serializable
    data class ViewRoute(
        val routeId: Int
    )
}