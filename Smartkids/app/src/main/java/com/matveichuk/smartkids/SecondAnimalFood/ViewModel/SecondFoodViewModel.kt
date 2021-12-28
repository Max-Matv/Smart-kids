package com.matveichuk.smartkids.SecondAnimalFood.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matveichuk.smartkids.AnimaFood.data.Food
import com.matveichuk.smartkids.AnimaFood.data.FoodData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SecondFoodViewModel : ViewModel() {

    val foodData = MutableLiveData<List<Food>>()
    var randomData = MutableList(3) { FoodData.getData().random() }.toSet().toMutableList()


    init {
        viewModelScope.launch(Dispatchers.IO) {
            setup()
        }
    }

    private fun setup() {
        foodData.postValue(randomData)
    }

    fun createList() {
        viewModelScope.launch {
            delay(1500)
            do {
                randomData.replaceAll {
                    FoodData.getData().random()
                }
            } while (randomData[0] == randomData[1] ||
                randomData[0] == randomData[2] ||
                randomData[1] == randomData[2]
            )
            setup()
        }
    }
}