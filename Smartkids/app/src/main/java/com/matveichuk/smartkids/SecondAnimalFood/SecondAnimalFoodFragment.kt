package com.matveichuk.smartkids.SecondAnimalFood

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.matveichuk.smartkids.R
import com.matveichuk.smartkids.SecondAnimalFood.Adapter.SecondAnimalFoodAdapter
import com.matveichuk.smartkids.SecondAnimalFood.ViewModel.SecondFoodViewModel
import com.matveichuk.smartkids.SoundEngine.SoundEngine
import com.matveichuk.smartkids.databinding.FragmentSecondAnimalFoodBinding
import com.matveichuk.smartkids.databinding.SecondFoodItemBinding
import com.matveichuk.smartkids.db.Score
import com.matveichuk.smartkids.db.ScoreViewModel
import org.koin.android.ext.android.inject

class SecondAnimalFoodFragment : Fragment() {

    private var binding: FragmentSecondAnimalFoodBinding? = null
    private val foodViewModel: SecondFoodViewModel by inject()
    private val scoreViewModel: ScoreViewModel by inject()
    private var soundEngine = SoundEngine()
    private var foodId = (0..2).random()
    var index = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSecondAnimalFoodBinding.inflate(inflater, container, false)
        this.binding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scoreViewModel.allScore.observe(viewLifecycleOwner, {
            index = it.size
        })
        binding?.recyclerFood?.layoutManager = GridLayoutManager(context, 3)
        foodViewModel.foodData.observe(viewLifecycleOwner, {
            binding?.recyclerFood?.adapter = SecondAnimalFoodAdapter(it) { food ->
                if (foodViewModel.randomData.indexOf(food) == foodId) {
                    play(R.raw.correct)
                    uiDisable()
                    animation(R.anim.scale)
                    Glide.with(view).load(R.drawable.ic_correct).into(binding!!.anim)
                    foodViewModel.createList()
                    binding!!.anim.visibility = View.INVISIBLE
                    binding?.recyclerFood?.adapter?.notifyDataSetChanged()
                    foodId = (0..2).random()
                    index++
                    scoreViewModel.insert(Score(index))
                } else {
                    play(R.raw.incorrect)
                }
            }
            uiEnable()
            Glide.with(view).load(foodViewModel.randomData[foodId].animalImage)
                .into(binding!!.animalImage)
        })
    }

    private fun animation(anim: Int) {
        binding?.anim?.visibility = View.VISIBLE
        AnimationUtils.loadAnimation(requireContext(), anim).also {
            binding?.anim?.startAnimation(it)
        }
    }

    private fun uiDisable() {
        binding?.animalImage?.visibility = View.GONE
        binding?.recyclerFood?.visibility = View.GONE
        binding?.title?.visibility = View.GONE
    }

    private fun uiEnable() {
        binding?.animalImage?.visibility = View.VISIBLE
        binding?.recyclerFood?.visibility = View.VISIBLE
        binding?.title?.visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun play(id: Int) {
        val soundToPlay =
            soundEngine.load(this.requireContext(), id, 1)
        soundEngine.play(soundToPlay, 6.0F, 6.0F, 1, 0, 1F)
    }

}