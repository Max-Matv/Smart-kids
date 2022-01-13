package com.matveichuk.smartkids.mainfragment.MainModule

import com.matveichuk.smartkids.mainfragment.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainViewModel = module {
    viewModel { MainViewModel() }
}