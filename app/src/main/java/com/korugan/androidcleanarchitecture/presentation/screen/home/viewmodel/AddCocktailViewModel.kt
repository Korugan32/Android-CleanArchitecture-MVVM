package com.korugan.androidcleanarchitecture.presentation.screen.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.korugan.androidcleanarchitecture.data.local.entity.Cocktails
import com.korugan.androidcleanarchitecture.domain.usecase.localroom.InsertCocktailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AddCocktailViewModel @Inject constructor(
    private val insertCocktailUseCase: InsertCocktailUseCase
) : ViewModel() {

    fun addCocktail(cocktail: Cocktails) {
        viewModelScope.launch {
            insertCocktailUseCase(cocktail)
        }
    }
}