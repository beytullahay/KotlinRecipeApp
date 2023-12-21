package com.example.kotlinrecipeapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinrecipeapp.databinding.PopularItemsBinding
import com.example.kotlinrecipeapp.pojo.CategoryList
import com.example.kotlinrecipeapp.pojo.CategoryMeals

class MostPopularAdapter(): RecyclerView.Adapter<MostPopularAdapter.PopularMealViewHolder>() {

    private var mealsList = ArrayList<CategoryMeals>()

    fun setMeals(mealsList: ArrayList<CategoryMeals>){
        this.mealsList = mealsList
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMealViewHolder {
        return PopularMealViewHolder(PopularItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return mealsList.size
    }

    override fun onBindViewHolder(holder: PopularMealViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(mealsList[position].strMealThumb)
            .into(holder.binding.imgPopularMealItem)
    }

    class PopularMealViewHolder( val binding: PopularItemsBinding): RecyclerView.ViewHolder(binding.root)

}