package com.korugan.androidcleanarchitecture.di.cocktail

import com.korugan.androidcleanarchitecture.data.remote.RandomCocktailAPI
import com.korugan.androidcleanarchitecture.data.repository.cocktail.CocktailRepositoryImpl
import com.korugan.androidcleanarchitecture.domain.repository.remote.CocktailRepository
import com.korugan.androidcleanarchitecture.util.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CocktailModule {

    @Singleton
    @Provides
    fun provideRandomCocktailApi(): RandomCocktailAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RandomCocktailAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideCocktailRepository(cocktailAPI: RandomCocktailAPI): CocktailRepository {
        return CocktailRepositoryImpl(cocktailAPI)
    }
}