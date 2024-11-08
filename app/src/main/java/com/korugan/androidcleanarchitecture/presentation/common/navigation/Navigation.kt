package com.korugan.androidcleanarchitecture.presentation.common.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.korugan.androidcleanarchitecture.presentation.home.HomeScreen
import com.korugan.androidcleanarchitecture.presentation.list.ListScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "HomeScreen") {
        composable(route = "HomeScreen") {
            HomeScreen(navHostController = navController)
        }
        composable(route = "List"){
            ListScreen(navHostController = navController)
        }
    }
}
