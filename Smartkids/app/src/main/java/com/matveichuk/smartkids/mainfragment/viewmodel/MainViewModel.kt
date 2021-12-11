package com.matveichuk.smartkids.mainfragment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matveichuk.smartkids.mainfragment.data.MainData
import com.matveichuk.smartkids.mainfragment.data.dataMain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val mainLiveData = MutableLiveData<List<MainData>>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            setup()
        }
    }

    private fun setup() {
        mainLiveData.postValue(dataMain.getData())
    }
}