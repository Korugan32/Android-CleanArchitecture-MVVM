package com.korugan.androidcleanarchitecture.domain.repository.remote

import com.korugan.androidcleanarchitecture.data.remote.dto.CocktailDto

interface CocktailRepository {
    suspend fun getRandomCocktail() : CocktailDto
    }