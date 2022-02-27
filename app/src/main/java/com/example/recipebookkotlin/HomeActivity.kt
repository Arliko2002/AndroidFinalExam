package com.example.recipebookkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipebookkotlin.adapter.MainCategoryAdapter
import com.example.recipebookkotlin.adapter.SubCategoryAdapter
import com.example.recipebookkotlin.database.RecipeDatabase
import com.example.recipebookkotlin.entities.CategoryItems
import com.example.recipebookkotlin.entities.Recipes
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import pub.devrel.easypermissions.EasyPermissions


class HomeActivity : BaseActivity(){
    var arrMainCategory = ArrayList<CategoryItems>()
    var arrSubCategory = ArrayList<Recipes>()
    var mainCategoryAdapter = MainCategoryAdapter()
    var subCategoryAdapter = SubCategoryAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        getDataFromDb();



        arrSubCategory.add(Recipes(1, "Beef and something"))
        arrSubCategory.add(Recipes(2, "Fish and something"))
        arrSubCategory.add(Recipes(3, "Chicken and something"))
        arrSubCategory.add(Recipes(4, "Lamb and something"))

        subCategoryAdapter.setData(arrSubCategory)


        rv_sub_category.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_sub_category.adapter = subCategoryAdapter

    }

    private fun getDataFromDb(){
       launch {
            this.let {
             var cat=RecipeDatabase.getDatabase(this@HomeActivity).recipeDao().getAllCategory()
                arrMainCategory=cat as ArrayList<CategoryItems>
                arrMainCategory.reverse()
                mainCategoryAdapter.setData(arrMainCategory)
                rv_main_category.layoutManager = LinearLayoutManager(this@HomeActivity, LinearLayoutManager.HORIZONTAL, false)
                rv_main_category.adapter = mainCategoryAdapter

            }

        }
    }


}
