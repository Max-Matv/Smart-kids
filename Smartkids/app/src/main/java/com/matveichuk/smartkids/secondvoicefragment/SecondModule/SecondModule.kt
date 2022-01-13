package com.matveichuk.smartkids.secondvoicefragment.SecondModule

import com.matveichuk.smartkids.secondvoicefragment.viewmodel.SecondVoiceViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val secondViewModel = module {
    viewModel { SecondVoiceViewModel() }
}