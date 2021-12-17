package com.matveichuk.smartkids.mainfragment.data

import com.matveichuk.smartkids.AnimalMaps.AnimalLocationFragment
import com.matveichuk.smartkids.R
import com.matveichuk.smartkids.rightplacefragment.RightPlaceFragment
import com.matveichuk.smartkids.secondvoicefragment.SecondAnimalVoiceFragment
import com.matveichuk.smartkids.voicefragment.AnimalVoiceFragment

object dataMain {
    fun getData(): List<MainData>{
        return listOf(
            MainData(R.drawable.ic_animalvoice,"Голоса животных?", AnimalVoiceFragment()),
            MainData(R.drawable.ic_animalwhosay, "Кто сказал?", SecondAnimalVoiceFragment()),
            MainData(R.drawable.ic_location, "Кто где живет?", AnimalLocationFragment()),
            MainData(R.drawable.ic_twotone_widgets_24, "Фигуры", RightPlaceFragment())
        )
    }
}