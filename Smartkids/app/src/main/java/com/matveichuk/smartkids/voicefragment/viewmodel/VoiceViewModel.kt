package com.matveichuk.smartkids.voicefragment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matveichuk.smartkids.voicefragment.data.VoiceData
import com.matveichuk.smartkids.voicefragment.data.Voice
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VoiceViewModel : ViewModel() {
    val livedata = MutableLiveData<List<VoiceData>>()

    init {
       viewModelScope.launch(Dispatchers.IO){
           setup()
       }
    }

      private fun setup() {
        livedata.postValue(Voice.getData())
    }
}