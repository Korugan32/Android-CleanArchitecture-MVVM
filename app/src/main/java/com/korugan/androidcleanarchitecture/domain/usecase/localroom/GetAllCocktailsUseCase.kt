package com.korugan.androidcleanarchitecture.domain.usecase.localroom

import com.korugan.androidcleanarchitecture.data.local.entity.Cocktails
import com.korugan.androidcleanarchitecture.domain.repository.roomdatabase.CocktailRoomRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCocktailsUseCase @Inject constructor(
    private val cocktailRoomRepository: CocktailRoomRepository
) {
    operator fun invoke(): Flow<List<Cocktails>> {
        return cocktailRoomRepository.getAllCocktails()
    }
}