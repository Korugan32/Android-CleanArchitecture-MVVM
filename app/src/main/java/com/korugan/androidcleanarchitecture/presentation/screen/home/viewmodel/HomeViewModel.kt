package com.korugan.androidcleanarchitecture.presentation.screen.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.korugan.androidcleanarchitecture.domain.usecase.remote.RandomCocktailUseCase
import com.korugan.androidcleanarchitecture.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val randomCocktailUseCase: RandomCocktailUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CocktailState())
    val state: StateFlow<CocktailState> = _state

    private var job: Job? = null


    init {
        getRandomCocktail()
    }

    fun getRandomCocktail() {
        job?.cancel()

        job = randomCocktailUseCase.getRandomCocktails().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = _state.value.copy(
                        cocktails = result.data ?: emptyList(),
                        isLoading = false,
                        error = ""
                    )
                }
                is Resource.Loading -> {
                    _state.value = _state.value.copy(
                        isLoading = true,
                        error = ""
                    )
                }
                is Resource.Error -> {
                    _state.value = _state.value.copy(
                        error = result.message ?: "An error occurred",
                        isLoading = false
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}