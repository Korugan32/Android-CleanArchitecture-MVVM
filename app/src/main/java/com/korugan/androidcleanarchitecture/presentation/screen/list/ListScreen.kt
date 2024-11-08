package com.korugan.androidcleanarchitecture.presentation.screen.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.korugan.androidcleanarchitecture.presentation.common.components.BottomBar
import com.korugan.androidcleanarchitecture.presentation.common.components.Header
import com.korugan.androidcleanarchitecture.presentation.screen.list.viewmodel.ManageCocktailViewModel

@Composable
fun ListScreen(
    roomViewModel: ManageCocktailViewModel = hiltViewModel(),
    navHostController: NavHostController
) {

    val roomState by roomViewModel.cocktails.collectAsState()

    Column(Modifier.statusBarsPadding()) {
        Scaffold(
            bottomBar = { BottomBar(navHostController) },
            topBar = { Header("ListScreen") },
        ) { paddingValues ->
            LazyColumn(
                modifier = Modifier.padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Button(onClick = { roomViewModel.deleteAllCocktails() }) {
                        Text("Delete All Database")
                    }
                }
                if (roomState.isNotEmpty()) {
                    items(roomState.size) { index ->
                        Column(Modifier.padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("Name : " + roomState[index].strDrink)
                            AsyncImage(roomState[index].strDrinkThumb, "")
                            Text("Category : " + roomState[index].strCategory)
                            Text("Type : " + roomState[index].strAlcoholic)
                            Text("Instructions : " + roomState[index].strInstructions)
                            Text("Id : " + roomState[index].idDrink)
                            Button(onClick = { roomViewModel.deleteCocktailById(roomState[index].id) }) {
                                Text("Delete")
                            }
                        }
                    }
                } else {
                    item {
                        Text("List is Empty")
                    }
                }
            }
        }
    }
}

