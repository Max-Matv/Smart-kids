package com.matveichuk.smartkids.AnimaFood

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.matveichuk.smartkids.AnimaFood.Adapter.AnimalFoodAdapter
import com.matveichuk.smartkids.AnimaFood.ViewModel.FoodViewModel
import com.matveichuk.smartkids.databinding.FragmentAnimalFoodBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AnimalFoodFragment : Fragment() {

    private var binding: FragmentAnimalFoodBinding? = null
    private val foodViewModel: FoodViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAnimalFoodBinding.inflate(inflater, container, false)
        this.binding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        foodViewModel.food.observe(viewLifecycleOwner, {
            binding?.viewPager?.adapter = AnimalFoodAdapter(it)
            TabLayoutMediator(binding!!.tab, binding!!.viewPager) { tab, position ->
            }.attach()
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}