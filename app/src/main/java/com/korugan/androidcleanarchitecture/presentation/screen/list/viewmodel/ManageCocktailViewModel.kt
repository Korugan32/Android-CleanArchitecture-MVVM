package com.korugan.androidcleanarchitecture.presentation.screen.list.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.korugan.androidcleanarchitecture.data.local.entity.Cocktails
import com.korugan.androidcleanarchitecture.domain.usecase.localroom.DeleteAllDatabaseUseCase
import com.korugan.androidcleanarchitecture.domain.usecase.localroom.DeleteCocktailByIdUseCase
import com.korugan.androidcleanarchitecture.domain.usecase.localroom.GetAllCocktailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ManageCocktailViewModel @Inject constructor(
    private val getAllCocktailsUseCase: GetAllCocktailsUseCase,
    private val deleteCocktailByIdUseCase: DeleteCocktailByIdUseCase,
    private val deleteAllDatabaseUseCase: DeleteAllDatabaseUseCase,
) : ViewModel() {

    private val _cocktails = MutableStateFlow<List<Cocktails>>(emptyList())
    val cocktails: StateFlow<List<Cocktails>> = _cocktails

    init {
        fetchAllCocktails()
    }

    private fun fetchAllCocktails() {
        viewModelScope.launch {
            getAllCocktailsUseCase().collect { cocktailsList ->
                _cocktails.value = cocktailsList
            }
        }
    }

    fun deleteCocktailById(id: Int) {
        viewModelScope.launch {
            deleteCocktailByIdUseCase(id)
        }
    }

    private fun deleteAllCocktails(){
        viewModelScope.launch {
            deleteAllDatabaseUseCase()
        }
    }
}