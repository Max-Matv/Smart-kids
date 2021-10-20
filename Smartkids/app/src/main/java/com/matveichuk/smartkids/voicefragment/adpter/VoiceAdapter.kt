package com.matveichuk.smartkids.voicefragment.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.matveichuk.smartkids.R
import com.matveichuk.smartkids.databinding.ItemBinding
import com.matveichuk.smartkids.voicefragment.SoundEngine.SoundEngine
import com.matveichuk.smartkids.voicefragment.data.VoiceData
import com.matveichuk.smartkids.voicefragment.data.voiceList

class VoiceAdapter(val data: List<VoiceData>) : RecyclerView.Adapter<VoiceAdapter.MyViewHolder>() {
    private var soundEngine = SoundEngine()


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemBinding.bind(itemView)
        fun bind(voice: VoiceData) = with(binding) {
            name.text = voice.name
            Glide.with(itemView).load(voice.image).into(image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
        holder.itemView.setOnClickListener {
            val soundToPlay = soundEngine.load(holder.itemView.context, voiceList.get(position), 1)
            soundEngine.play(soundToPlay, 6.0F, 6.0F, 1, 0, 1F)
        }
    }

    override fun getItemCount(): Int = data.size
}