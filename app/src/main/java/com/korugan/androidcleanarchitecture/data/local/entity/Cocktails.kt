package com.korugan.androidcleanarchitecture.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Cocktails(
    val idDrink: String,
    val strAlcoholic: String,
    val strCategory: String,
    val strDrink: String,
    val strDrinkThumb: String,
    val strInstructions: String,
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0
)
