package com.korugan.androidcleanarchitecture.data.mapper

import com.korugan.androidcleanarchitecture.data.remote.dto.CocktailDto
import com.korugan.androidcleanarchitecture.domain.model.Cocktail

fun CocktailDto.toCocktail(): List<Cocktail> {
    return drinks.map {
        Cocktail(
            strInstructions = it.strInstructions,
            strAlcoholic = it.strAlcoholic,
            strDrink = it.strDrink,
            strCategory = it.strCategory,
            strDrinkThumb = it.strDrinkThumb,
            idDrink = it.idDrink,
        )
    }
}