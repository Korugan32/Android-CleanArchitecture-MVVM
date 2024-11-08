package com.korugan.androidcleanarchitecture.di.cocktailroom

import android.content.Context
import androidx.room.Room
import com.korugan.androidcleanarchitecture.data.local.dao.CocktailsDao
import com.korugan.androidcleanarchitecture.data.local.database.CocktailsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CocktailDatabaseModule {

    @Singleton
    @Provides
    fun provideCocktailDatabase(@ApplicationContext context: Context): CocktailsDatabase {
        return Room.databaseBuilder(
            context,
            CocktailsDatabase::class.java,
            "cocktails_database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideCocktailDao(cocktailsDatabase: CocktailsDatabase): CocktailsDao {
        return cocktailsDatabase.cocktailsDao()
    }
}