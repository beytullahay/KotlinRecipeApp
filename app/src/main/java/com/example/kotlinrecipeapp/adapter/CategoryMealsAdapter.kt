package com.example.kotlinrecipeapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinrecipeapp.databinding.ActivityCategoryMealsBinding
import com.example.kotlinrecipeapp.databinding.MealItemBinding
import com.example.kotlinrecipeapp.pojo.Category
import com.example.kotlinrecipeapp.pojo.MealsByCategory

class CategoryMealsAdapter : RecyclerView.Adapter<CategoryMealsAdapter.CategoryMealsViewModel>() {
    private var mealsList = ArrayList<MealsByCategory>()  // yemek id, ismi ve görsel listesi


    // listeyi fonksiyon içinde mealsList ile yayınlıyoruz.
    fun setMealsList(mealsList:List<MealsByCategory>){
        this.mealsList = mealsList as ArrayList<MealsByCategory>
        notifyDataSetChanged()
    }

    // iç sınıf yani inner class
    inner class CategoryMealsViewModel(val binding: MealItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryMealsViewModel {
        return CategoryMealsViewModel((
                MealItemBinding.inflate( // xml baglama islemi
                    LayoutInflater.from(parent.context)
                )
                ))
    }

    override fun getItemCount(): Int {
        return  mealsList.size
    }

    override fun onBindViewHolder(holder: CategoryMealsViewModel, position: Int) {
        // xmldeki yerlerine modelin listesinden gelen veriyi yerleştiriyoruz.
        Glide.with(holder.itemView).load(mealsList[position].strMealThumb).into(holder.binding.imgMeal)
        holder.binding.tvMealName.text = mealsList[position].strMeal
    }
}