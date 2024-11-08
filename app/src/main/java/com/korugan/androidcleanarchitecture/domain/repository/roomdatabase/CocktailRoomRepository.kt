package com.korugan.androidcleanarchitecture.domain.repository.roomdatabase

import com.korugan.androidcleanarchitecture.data.local.entity.Cocktails
import kotlinx.coroutines.flow.Flow

interface CocktailRoomRepository {
    fun getAllCocktails() : Flow<List<Cocktails>>
    suspend fun insertCocktails(cocktails: Cocktails)
    suspend fun deleteCocktailById(id:Int)
    suspend fun deleteAllCocktails()
}