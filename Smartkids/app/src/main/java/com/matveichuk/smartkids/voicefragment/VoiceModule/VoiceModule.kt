package com.matveichuk.smartkids.voicefragment.VoiceModule

import com.matveichuk.smartkids.voicefragment.viewmodel.VoiceViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val voiceViewModel = module {
    viewModel { VoiceViewModel() }
}