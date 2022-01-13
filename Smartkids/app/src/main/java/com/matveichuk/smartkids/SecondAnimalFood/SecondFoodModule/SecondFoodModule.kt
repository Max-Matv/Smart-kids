package com.matveichuk.smartkids.SecondAnimalFood.SecondFoodModule

import com.matveichuk.smartkids.SecondAnimalFood.ViewModel.SecondFoodViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val secondFoodViewModel = module {
    viewModel { SecondFoodViewModel() }
}