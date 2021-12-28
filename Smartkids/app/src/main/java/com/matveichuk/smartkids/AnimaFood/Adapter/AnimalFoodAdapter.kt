package com.matveichuk.smartkids.AnimaFood.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.matveichuk.smartkids.AnimaFood.data.Food
import com.matveichuk.smartkids.R
import com.matveichuk.smartkids.databinding.FoodItemBinding

class AnimalFoodAdapter(val data: List<Food>) :
    RecyclerView.Adapter<AnimalFoodAdapter.MyViewHolder>() {


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = FoodItemBinding.bind(itemView)
        fun bind(foodData: Food) = with(binding) {
            title.text = foodData.title
            food.text = foodData.food
            Glide.with(itemView).load(foodData.animalImage).into(animalImage)
            Glide.with(itemView).load(foodData.foodImage).into(foodImage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}