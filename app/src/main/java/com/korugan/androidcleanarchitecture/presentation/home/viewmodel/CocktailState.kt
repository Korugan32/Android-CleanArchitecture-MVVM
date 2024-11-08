package com.korugan.androidcleanarchitecture.presentation.home.viewmodel

import com.korugan.androidcleanarchitecture.domain.model.Cocktail

data class CocktailState(
    val cocktails: List<Cocktail> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)