package com.example.recipebookkotlin.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.recipebookkotlin.RecipeDao
import com.example.recipebookkotlin.entities.Category
import com.example.recipebookkotlin.entities.CategoryItems
import com.example.recipebookkotlin.entities.Recipes
import com.example.recipebookkotlin.entities.converter.CategoryListConverter


@Database(entities = [Recipes::class,CategoryItems::class,
    Category::class, CategoryListConverter::class], version = 1, exportSchema = false)
abstract class RecipeDatabase: RoomDatabase() {
    companion object{
        var recipeDatabase:RecipeDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): RecipeDatabase {
            if (recipeDatabase == null) {
                recipeDatabase =
                    Room.databaseBuilder(context, RecipeDatabase::class.java, "recipe.db")
                .build()}
            return recipeDatabase!!
        }
    }
    abstract fun recipeDao(): RecipeDao
}