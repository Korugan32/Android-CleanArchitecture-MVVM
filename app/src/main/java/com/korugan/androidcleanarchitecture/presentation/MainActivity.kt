package com.korugan.androidcleanarchitecture.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.korugan.androidcleanarchitecture.presentation.common.navigation.Navigation
import com.korugan.androidcleanarchitecture.presentation.home.HomeScreen
import com.korugan.androidcleanarchitecture.presentation.ui.theme.AndroidCleanArchitectureTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidCleanArchitectureTheme {
               Navigation()
            }
        }
    }
}