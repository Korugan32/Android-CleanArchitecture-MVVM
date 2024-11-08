package com.korugan.androidcleanarchitecture.domain.usecase.remote

import com.korugan.androidcleanarchitecture.data.mapper.toCocktail
import com.korugan.androidcleanarchitecture.domain.model.Cocktail
import com.korugan.androidcleanarchitecture.domain.repository.remote.CocktailRepository
import com.korugan.androidcleanarchitecture.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RandomCocktailUseCase @Inject constructor(
    private val cocktailRepository: CocktailRepository
) {
    fun getRandomCocktails(): Flow<Resource<List<Cocktail>>> = flow {
        try {
            emit(Resource.Loading())
            val cocktails = cocktailRepository.getRandomCocktail()
            if (cocktails.drinks.isNotEmpty()) {
                emit(Resource.Success(cocktails.toCocktail()))
            } else {
                emit(Resource.Error("No Cocktails Found"))
            }
        } catch (e: HttpException) {
            emit(Resource.Error("Error : ${e}"))
        } catch (e: IOException) {
            emit(Resource.Error("Error : ${e}"))
        }
    }
}