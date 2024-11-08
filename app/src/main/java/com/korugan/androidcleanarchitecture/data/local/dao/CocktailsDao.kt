package com.korugan.androidcleanarchitecture.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.korugan.androidcleanarchitecture.data.local.entity.Cocktails
import kotlinx.coroutines.flow.Flow

@Dao
interface CocktailsDao {

    @Query("SELECT * FROM Cocktails")
    fun getAllCocktails() : Flow<List<Cocktails>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCocktails(cocktails: Cocktails)

    @Query("DELETE FROM Cocktails WHERE id = :id")
    suspend fun deleteCocktailById(id:Int)

    @Query("DELETE FROM Cocktails")
    suspend fun deleteAllCocktails()

}