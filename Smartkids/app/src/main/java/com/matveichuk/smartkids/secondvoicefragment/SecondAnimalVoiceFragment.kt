package com.matveichuk.smartkids.secondvoicefragment


import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.green
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.matveichuk.smartkids.R
import com.matveichuk.smartkids.SoundEngine.SoundEngine
import com.matveichuk.smartkids.databinding.FragmentSecondAnimalVoiceBinding
import com.matveichuk.smartkids.db.Score
import com.matveichuk.smartkids.db.ScoreApplication
import com.matveichuk.smartkids.db.ScoreViewModel
import com.matveichuk.smartkids.db.ScoreViewModelFactory
import com.matveichuk.smartkids.secondvoicefragment.adapter.SecondVoiceAdapter
import com.matveichuk.smartkids.secondvoicefragment.viewmodel.SecondVoiceViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class SecondAnimalVoiceFragment : Fragment() {

    private var soundEngine = SoundEngine()
    private var binding: FragmentSecondAnimalVoiceBinding? = null
    lateinit var voiceViewModel: SecondVoiceViewModel
    private var voiceId = (0..2).random()
    private val scoreViewModel: ScoreViewModel by viewModels {
        ScoreViewModelFactory((activity?.application as ScoreApplication).repository)
    }
    var index = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSecondAnimalVoiceBinding.inflate(inflater, container, false)
        this.binding = binding
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.recyclerVoice?.layoutManager = GridLayoutManager(context, 3)
        val context = this.context as AppCompatActivity
        scoreViewModel.allScore.observe(viewLifecycleOwner, {
            Log.e("TAG", it.toString())
            binding?.score?.text = it?.size.toString()
            index = it.size
        })
        voiceViewModel =
            activity.run { ViewModelProviders.of(context)[SecondVoiceViewModel::class.java] }
        voiceViewModel.liveData.observe(viewLifecycleOwner, {
            binding?.recyclerVoice?.adapter = SecondVoiceAdapter(it) { voice ->
                if (voiceViewModel.voiceListData.indexOf(voice) == voiceId) {
                    play(R.raw.correct)
                    animation(R.anim.scale)
                    Glide.with(view).load(R.drawable.ic_correct).into(binding!!.animalImage)
                    voiceViewModel.createList()
                    binding!!.animalImage.visibility = View.INVISIBLE
                    binding?.recyclerVoice?.adapter?.notifyDataSetChanged()
                    voiceId = (0..2).random()
                    index++
                    scoreViewModel.insert(Score(index))
                } else {
                    play(R.raw.incorrect)
                    animation(R.anim.scale)
                    Glide.with(view).load(R.drawable.ic_incorrect).into(binding!!.animalImage)
                }
            }
            play(voiceViewModel.voiceListData[voiceId].song)
            binding?.repeat?.setOnClickListener {
                play(voiceViewModel.voiceListData[voiceId].song)
            }
        })
    }

    private fun animation(anim: Int) {
        binding?.animalImage?.visibility = View.VISIBLE
        AnimationUtils.loadAnimation(requireContext(), anim).also {
            binding?.animalImage?.startAnimation(it)
        }
    }

    private fun play(id: Int) {
        val soundToPlay =
            soundEngine.load(this.requireContext(), id, 1)
        soundEngine.play(soundToPlay, 6.0F, 6.0F, 1, 0, 1F)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}