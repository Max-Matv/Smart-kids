package com.matveichuk.smartkids.AnimalMaps.AnimalLocationVIewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.model.PolygonOptions
import com.matveichuk.smartkids.AnimalMaps.data.Location
import com.matveichuk.smartkids.AnimalMaps.data.LocationData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnimalLocationViewModel : ViewModel() {
    var idMap = MutableLiveData<PolygonOptions>()
    val listData = MutableLiveData<MutableList<LocationData>>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            setup()
        }
    }
    private fun setup(){
        listData.postValue(Location.getLocation())
    }
}