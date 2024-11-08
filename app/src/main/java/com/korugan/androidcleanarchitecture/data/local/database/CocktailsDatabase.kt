package com.korugan.androidcleanarchitecture.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.korugan.androidcleanarchitecture.data.local.dao.CocktailsDao
import com.korugan.androidcleanarchitecture.data.local.entity.Cocktails

@Database(entities = [Cocktails::class], version = 1)
abstract class CocktailsDatabase : RoomDatabase() {

    abstract fun cocktailsDao(): CocktailsDao

    companion object {
        @Volatile
        private var INSTANCE: CocktailsDatabase? = null

        fun getDatabase(context: Context): CocktailsDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CocktailsDatabase::class.java,
                    "cocktails_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}