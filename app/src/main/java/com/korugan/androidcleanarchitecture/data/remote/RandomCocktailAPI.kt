package com.korugan.androidcleanarchitecture.data.remote

import com.korugan.androidcleanarchitecture.data.remote.dto.CocktailDto
import retrofit2.http.GET

interface RandomCocktailAPI {
    @GET("random.php")
    suspend fun getRandomCocktail() : CocktailDto
}