package com.example.recipebookkotlin.entities

import android.icu.util.ULocale
import androidx.room.*
import com.example.recipebookkotlin.entities.converter.CategoryListConverter
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Category")
data class Category(
    @PrimaryKey(autoGenerate = true)
    var id:Int,

    @ColumnInfo(name = "CategoriesItems")
    @Expose
    @SerializedName("categories")
    @TypeConverters(CategoryListConverter::class)
    var CategoriesItems: List<CategoryItems>
)
