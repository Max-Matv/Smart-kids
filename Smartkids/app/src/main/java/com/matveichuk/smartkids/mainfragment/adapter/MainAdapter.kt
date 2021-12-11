package com.matveichuk.smartkids.mainfragment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.matveichuk.smartkids.R
import com.matveichuk.smartkids.databinding.ItemBinding
import com.matveichuk.smartkids.mainfragment.data.MainData


class MainAdapter(val data: List<MainData>, val delegate: (MainData) -> Unit) :
    RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemBinding.bind(itemView)
        fun bind(mainData: MainData, delegate: (MainData) -> Unit) = with(binding) {
            name.text = mainData.name
            Glide.with(itemView).load(mainData.image).into(image)
            itemView.setOnClickListener { delegate(mainData) }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.second_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position], delegate)
    }

    override fun getItemCount(): Int = data.size
}