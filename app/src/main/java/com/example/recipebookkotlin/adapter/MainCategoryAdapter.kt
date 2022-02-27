package com.example.recipebookkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipebookkotlin.R

import android.content.Context
import com.bumptech.glide.Glide
import com.example.recipebookkotlin.entities.CategoryItems
import com.example.recipebookkotlin.entities.Recipes
import kotlinx.android.synthetic.main.item_rv_main_category.view.*


class MainCategoryAdapter: RecyclerView.Adapter<MainCategoryAdapter.RecipeViewHolder>() {
    var ctx:Context?=null
    var arrMainCategory = ArrayList<CategoryItems>()
    class RecipeViewHolder(view: View):RecyclerView.ViewHolder(view){


    }
    fun setData(arrData : List<CategoryItems>){
        arrMainCategory = arrData as ArrayList<CategoryItems>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
       ctx=parent.context
        return RecipeViewHolder((LayoutInflater.from(parent.context).inflate(R.layout.item_rv_main_category, parent, false)))
    }

    override fun getItemCount(): Int {
        return arrMainCategory.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.itemView.tv_dish_name.text = arrMainCategory[position].Strcategory

        Glide.with(ctx!!).load(arrMainCategory[position].Strcategorythumb).into(holder.itemView.img_dish)
    }
}