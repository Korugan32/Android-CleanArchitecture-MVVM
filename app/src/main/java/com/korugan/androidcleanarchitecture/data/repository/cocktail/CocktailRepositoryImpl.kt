package com.korugan.androidcleanarchitecture.data.repository.cocktail

import com.korugan.androidcleanarchitecture.data.remote.RandomCocktailAPI
import com.korugan.androidcleanarchitecture.data.remote.dto.CocktailDto
import com.korugan.androidcleanarchitecture.domain.repository.remote.CocktailRepository
import javax.inject.Inject

class CocktailRepositoryImpl @Inject constructor(
    private val randomCocktailAPI: RandomCocktailAPI,
) : CocktailRepository{

    override suspend fun getRandomCocktail(): CocktailDto {
        return randomCocktailAPI.getRandomCocktail()
    }
}