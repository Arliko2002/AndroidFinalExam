package com.example.recipebookkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipebookkotlin.R

import android.content.Context
import com.bumptech.glide.Glide
import com.example.recipebookkotlin.entities.Recipes
import kotlinx.android.synthetic.main.item_rv_main_category.view.*


class SubCategoryAdapter: RecyclerView.Adapter<SubCategoryAdapter.RecipeViewHolder>() {
    var arrSubCategory = ArrayList<Recipes>()
    class RecipeViewHolder(view: View):RecyclerView.ViewHolder(view){


    }
    fun setData(arrData : List<Recipes>){
        arrSubCategory = arrData as ArrayList<Recipes>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder((LayoutInflater.from(parent.context).inflate(R.layout.activity_item_rv_sub_category, parent, false)))
    }

    override fun getItemCount(): Int {
        return arrSubCategory.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.itemView.tv_dish_name.text = arrSubCategory[position].dishName
    }
}