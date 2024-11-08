package com.korugan.androidcleanarchitecture.di.cocktailroom

import com.korugan.androidcleanarchitecture.data.repository.cocktailroom.CocktailRoomRepositoryImpl
import com.korugan.androidcleanarchitecture.domain.repository.roomdatabase.CocktailRoomRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CocktailRoomRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCocktailRoomRepository(
        cocktailRoomRepositoryImpl: CocktailRoomRepositoryImpl
    ): CocktailRoomRepository
}