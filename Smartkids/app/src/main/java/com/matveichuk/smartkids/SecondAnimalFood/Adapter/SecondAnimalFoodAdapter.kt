package com.matveichuk.smartkids.SecondAnimalFood.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.matveichuk.smartkids.AnimaFood.data.Food
import com.matveichuk.smartkids.R
import com.matveichuk.smartkids.databinding.SecondFoodItemBinding

class SecondAnimalFoodAdapter(val data: List<Food>, val delegate: (Food) -> Unit) :
    RecyclerView.Adapter<SecondAnimalFoodAdapter.MyViewHolder>() {


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = SecondFoodItemBinding.bind(itemView)
        fun bind(food: Food, delegate: (Food) -> Unit) = with(binding) {
            Glide.with(itemView).load(food.foodImage).into(image)
            itemView.setOnClickListener {
                delegate(food)
                image.setBackgroundResource(R.drawable.wrong_circle)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.second_food_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position], delegate)
        holder.itemView.animation =
            AnimationUtils.loadAnimation(holder.itemView.context, R.anim.rc_item_anim)
    }

    override fun getItemCount(): Int = data.size
}