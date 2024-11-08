package com.korugan.androidcleanarchitecture.domain.usecase.localroom

import com.korugan.androidcleanarchitecture.data.local.entity.Cocktails
import com.korugan.androidcleanarchitecture.domain.repository.roomdatabase.CocktailRoomRepository
import javax.inject.Inject

class InsertCocktailUseCase @Inject constructor(
    private val cocktailRoomRepository: CocktailRoomRepository
) {
    suspend operator fun invoke(cocktails: Cocktails) {
        cocktailRoomRepository.insertCocktails(cocktails)
    }
}