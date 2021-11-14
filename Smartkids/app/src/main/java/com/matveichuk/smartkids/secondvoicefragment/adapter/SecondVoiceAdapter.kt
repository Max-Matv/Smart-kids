package com.matveichuk.smartkids.secondvoicefragment.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.matveichuk.smartkids.R
import com.matveichuk.smartkids.databinding.ItemBinding
import com.matveichuk.smartkids.secondvoicefragment.data.SecondVoiceData

class SecondVoiceAdapter(val data: MutableList<SecondVoiceData>, val delegate: (SecondVoiceData) -> Unit) :
    RecyclerView.Adapter<SecondVoiceAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemBinding.bind(itemView)
        fun bind(voice: SecondVoiceData, delegate: (SecondVoiceData) -> Unit) = with(binding) {
            Glide.with(itemView).load(voice.image).into(image)
            itemView.setOnClickListener { delegate(voice) }
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