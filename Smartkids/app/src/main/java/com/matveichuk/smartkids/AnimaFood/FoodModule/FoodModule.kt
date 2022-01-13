package com.matveichuk.smartkids.AnimaFood.FoodModule

import com.matveichuk.smartkids.AnimaFood.ViewModel.FoodViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val foodViewModel = module {
    viewModel { FoodViewModel() }
}