package com.matveichuk.smartkids.Apifragment.api

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CatViewModel(val apiService: ApiCat) : ViewModel() {
    val catData = MutableLiveData<Cat>()

//    fun getData() {
//        apiService.getData().enqueue(object : Callback<Cat>{
//            override fun onResponse(call: Call<Cat>, response: Response<Cat>) {
//                catData.value = response.body()
//            }
//
//            override fun onFailure(call: Call<Cat>, t: Throwable) {
//            }
//
//        })
//    }
}