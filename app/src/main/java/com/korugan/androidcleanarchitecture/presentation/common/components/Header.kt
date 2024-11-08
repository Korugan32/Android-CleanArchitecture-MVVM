package com.korugan.androidcleanarchitecture.presentation.common.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header(headerText : String){
    Row(Modifier.fillMaxWidth().height(60.dp).padding(20.dp)) {
        Text(headerText, fontWeight = FontWeight.Bold, fontSize = 20.sp)
    }
}