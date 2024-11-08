package com.korugan.androidcleanarchitecture.domain.usecase.localroom

import com.korugan.androidcleanarchitecture.domain.repository.roomdatabase.CocktailRoomRepository
import javax.inject.Inject

class DeleteCocktailByIdUseCase @Inject constructor(
    private val cocktailRoomRepository: CocktailRoomRepository
) {
    suspend operator fun invoke(id: Int) {
        cocktailRoomRepository.deleteCocktailById(id)
    }
}