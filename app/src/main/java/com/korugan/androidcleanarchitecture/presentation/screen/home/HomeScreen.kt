package com.korugan.androidcleanarchitecture.presentation.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
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
import com.korugan.androidcleanarchitecture.data.local.entity.Cocktails
import com.korugan.androidcleanarchitecture.presentation.common.components.BottomBar
import com.korugan.androidcleanarchitecture.presentation.common.components.Header
import com.korugan.androidcleanarchitecture.presentation.screen.home.viewmodel.AddCocktailViewModel
import com.korugan.androidcleanarchitecture.presentation.screen.home.viewmodel.HomeViewModel


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    viewModelRoom: AddCocktailViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    val state by viewModel.state.collectAsState()

    Column(modifier = Modifier.statusBarsPadding()) {
        var cocktails: Cocktails? = null
        when {
            state.isLoading -> {
                CircularProgressIndicator()
            }

            state.cocktails.isNotEmpty() -> {
                cocktails = Cocktails(
                    idDrink = state.cocktails[0].idDrink,
                    strInstructions = state.cocktails[0].strInstructions,
                    strDrink = state.cocktails[0].strDrink,
                    strAlcoholic = state.cocktails[0].strAlcoholic,
                    strDrinkThumb = state.cocktails[0].strDrinkThumb,
                    strCategory = state.cocktails[0].strCategory,
                )
                // Kokteylleri listele
                Scaffold(
                    topBar = { Header("HomeScreen") },
                    bottomBar = { BottomBar(navHostController) }
                ) { paddingValues ->
                    LazyColumn(Modifier.padding(paddingValues), horizontalAlignment = Alignment.CenterHorizontally) {
                        items(state.cocktails.size) { cocktail ->
                            Column(Modifier.padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("Name : " + state.cocktails[cocktail].strDrink)
                                AsyncImage(state.cocktails[cocktail].strDrinkThumb, "")
                                Text("Category : " + state.cocktails[cocktail].strCategory)
                                Text("Type : " + state.cocktails[cocktail].strAlcoholic)
                                Text("Instructions : " + state.cocktails[cocktail].strInstructions)
                                Text("Id : " + state.cocktails[cocktail].idDrink)
                            }
                        }
                        item {
                            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                                Button(onClick = { viewModel.getRandomCocktail() }) {
                                    Text(text = "Get Random Cocktail")
                                }
                                Spacer(Modifier.padding(15.dp))
                                Button(onClick = {
                                    cocktails?.let {
                                        viewModelRoom.addCocktail(it)  // Null değilse ekleme yapılır
                                    }
                                }) {
                                    Text(text = "Add Database")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}