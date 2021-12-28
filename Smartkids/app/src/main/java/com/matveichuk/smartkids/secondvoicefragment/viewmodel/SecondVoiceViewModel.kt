package com.matveichuk.smartkids.secondvoicefragment.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matveichuk.smartkids.secondvoicefragment.data.SecondVoice
import com.matveichuk.smartkids.secondvoicefragment.data.SecondVoiceData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SecondVoiceViewModel : ViewModel() {
    var voiceListData = MutableList(3) { SecondVoice.getData().random() }.toSet().toMutableList()
    val liveData = MutableLiveData<MutableList<SecondVoiceData>>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            setup()
        }
    }

      private fun setup() {

        liveData.postValue(voiceListData)
    }
    @RequiresApi(Build.VERSION_CODES.N)
    fun createList(){
        viewModelScope.launch {
            delay(1500)
            do {
                voiceListData.replaceAll {
                    SecondVoice.getData().random()
                }
            } while (voiceListData[0] == voiceListData[1] ||
                voiceListData[0] == voiceListData[2] ||
                voiceListData[1] == voiceListData[2]
            )
            setup()
        }

    }
}
