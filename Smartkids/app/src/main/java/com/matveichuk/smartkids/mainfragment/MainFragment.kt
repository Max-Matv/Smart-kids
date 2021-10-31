package com.matveichuk.smartkids.mainfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.matveichuk.smartkids.R
import com.matveichuk.smartkids.databinding.FragmentMainBinding
import com.matveichuk.smartkids.rightplacefragment.RightPlaceFragment
import com.matveichuk.smartkids.secondvoicefragment.SecondAnimalVoiceFragment
import com.matveichuk.smartkids.voicefragment.AnimalVoiceFragment


class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainBinding.inflate(inflater, container, false)
        this.binding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(view).load(R.drawable.ic_animalvoice).into(binding!!.animalVoice)
        binding?.animalVoice?.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.setCustomAnimations(R.anim.scale, R.anim.fade_out)
                ?.replace(R.id.recycleList, AnimalVoiceFragment())
                ?.commit()
        }
        Glide.with(view).load(R.drawable.ic_animalwhosay).into(binding!!.whoSay)
        binding?.whoSay?.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.setCustomAnimations(R.anim.scale, R.anim.fade_out)
                ?.replace(R.id.recycleList, SecondAnimalVoiceFragment())
                ?.commit()
        }
        Glide.with(view).load(R.drawable.ic_twotone_widgets_24).into(binding!!.figure)
        binding?.figure?.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.setCustomAnimations(R.anim.scale, R.anim.fade_out)
                ?.replace(R.id.recycleList, RightPlaceFragment())
                ?.commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}