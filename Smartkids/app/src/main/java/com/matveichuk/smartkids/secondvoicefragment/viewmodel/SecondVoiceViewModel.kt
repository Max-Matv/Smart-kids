package com.matveichuk.smartkids.secondvoicefragment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matveichuk.smartkids.secondvoicefragment.data.SecondVoice
import com.matveichuk.smartkids.secondvoicefragment.data.SecondVoiceData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SecondVoiceViewModel : ViewModel() {
    var voiceListData = MutableList(3) { SecondVoice.getData().random() }.toSet().toMutableList()
    val liveData: MutableLiveData<List<SecondVoiceData>> = MutableLiveData()

    init {
        viewModelScope.launch(Dispatchers.Main) {
            setup()
        }
    }

      private fun setup() {

        liveData.value = voiceListData
    }
}
