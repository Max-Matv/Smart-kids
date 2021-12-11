package com.matveichuk.smartkids.Apifragment.api

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matveichuk.smartkids.Apifragment.api.facts.Data


class ApiViewModel : ViewModel() {

    private val apiLiveData = MutableLiveData<Data>()

}