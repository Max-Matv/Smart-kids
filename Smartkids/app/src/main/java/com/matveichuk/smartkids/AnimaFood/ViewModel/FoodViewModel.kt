package com.matveichuk.smartkids.AnimaFood.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matveichuk.smartkids.AnimaFood.data.Food
import com.matveichuk.smartkids.AnimaFood.data.FoodData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FoodViewModel : ViewModel() {
    val food = MutableLiveData<List<Food>>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            setup()
        }
    }

    private fun setup() {
        food.postValue(FoodData.getData())
    }
}