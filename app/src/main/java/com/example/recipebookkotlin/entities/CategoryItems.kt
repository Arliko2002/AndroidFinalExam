package com.example.recipebookkotlin.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
@Entity(tableName = "CategoryItems")
data class CategoryItems(
    @PrimaryKey(autoGenerate = true)
    var id:Int,

    @ColumnInfo(name = "Idcategory")
    @Expose
    @SerializedName("idCategory")
    val Idcategory: String,

    @ColumnInfo(name = "Strcategory")
    @Expose
    @SerializedName("strCategory")
    val Strcategory: String,

    @ColumnInfo(name = "Strcategorythumb")
    @Expose
    @SerializedName("strCategoryThumb")
    val Strcategorythumb: String,

    @ColumnInfo(name = "Strcategorydescription")
    @Expose
    @SerializedName("strCategoryDescription")
    val Strcategorydescription: String
)

