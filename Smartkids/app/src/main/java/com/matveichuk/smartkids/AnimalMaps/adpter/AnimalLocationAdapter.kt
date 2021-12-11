package com.matveichuk.smartkids.AnimalMaps.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.matveichuk.smartkids.AnimalMaps.data.LocationData
import com.matveichuk.smartkids.R
import com.matveichuk.smartkids.databinding.ItemBinding

class AnimalLocationAdapter(
    val data: MutableList<LocationData>,
    val delegate: (LocationData) -> Unit
) : RecyclerView.Adapter<AnimalLocationAdapter.MyViewHolder>() {


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemBinding.bind(itemView)
        fun bind(location: LocationData, delegate: (LocationData) -> Unit) = with(binding) {
            Glide.with(itemView).load(location.image).into(image)
            name.text = location.name
            itemView.setOnClickListener { delegate(location) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position], delegate)
    }

    override fun getItemCount(): Int = data.size
}