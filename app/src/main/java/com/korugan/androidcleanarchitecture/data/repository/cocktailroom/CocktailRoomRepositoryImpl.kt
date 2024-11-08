package com.korugan.androidcleanarchitecture.data.repository.cocktailroom

import com.korugan.androidcleanarchitecture.data.local.dao.CocktailsDao
import com.korugan.androidcleanarchitecture.data.local.entity.Cocktails
import com.korugan.androidcleanarchitecture.domain.repository.roomdatabase.CocktailRoomRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CocktailRoomRepositoryImpl @Inject constructor(private val cocktailsDao: CocktailsDao) : CocktailRoomRepository {
    override fun getAllCocktails(): Flow<List<Cocktails>> {
        return cocktailsDao.getAllCocktails()
    }

    override suspend fun insertCocktails(cocktails: Cocktails) {
        cocktailsDao.insertCocktails(cocktails)
    }

    override suspend fun deleteCocktailById(id: Int) {
        cocktailsDao.deleteCocktailById(id)
    }

    override suspend fun deleteAllCocktails() {
        cocktailsDao.deleteAllCocktails()
    }

}