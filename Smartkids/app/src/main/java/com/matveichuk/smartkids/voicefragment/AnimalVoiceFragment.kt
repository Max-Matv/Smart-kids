package com.matveichuk.smartkids.voicefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager

import com.matveichuk.smartkids.databinding.FragmentAnimalVoiceBinding


import com.matveichuk.smartkids.voicefragment.adpter.VoiceAdapter

import com.matveichuk.smartkids.voicefragment.viewmodel.VoiceViewModel
import org.koin.android.ext.android.inject


class AnimalVoiceFragment : Fragment() {
    private var binding: FragmentAnimalVoiceBinding? = null
    private val voiceViewModel: VoiceViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAnimalVoiceBinding.inflate(inflater, container, false)
        this.binding = binding
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        binding?.recycler?.layoutManager = GridLayoutManager(context, 2)
        voiceViewModel.livedata.observe(viewLifecycleOwner, {
            binding?.progress?.visibility = View.GONE
            binding?.recycler?.adapter = VoiceAdapter(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}