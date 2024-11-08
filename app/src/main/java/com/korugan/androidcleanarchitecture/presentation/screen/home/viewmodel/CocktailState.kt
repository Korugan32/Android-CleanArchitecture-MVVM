package com.korugan.androidcleanarchitecture.presentation.screen.home.viewmodel

import com.korugan.androidcleanarchitecture.domain.model.Cocktail

data class CocktailState(
    val cocktails: List<Cocktail> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)