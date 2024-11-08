package com.korugan.androidcleanarchitecture.presentation.common.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun BottomBar(navHostController: NavHostController) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(60.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {

        Icon(Icons.Default.Home, "",
            Modifier
                .size(40.dp)
                .clickable {
                    navHostController.navigate("HomeScreen")
                })


        Icon(Icons.Default.FavoriteBorder, "",
            Modifier
                .size(40.dp)
                .clickable {
                    navHostController.navigate("List")
                })
    }
}