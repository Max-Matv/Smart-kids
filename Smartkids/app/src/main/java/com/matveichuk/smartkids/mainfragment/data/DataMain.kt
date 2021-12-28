package com.matveichuk.smartkids.mainfragment.data

import com.matveichuk.smartkids.AnimaFood.AnimalFoodFragment
import com.matveichuk.smartkids.R
import com.matveichuk.smartkids.SecondAnimalFood.SecondAnimalFoodFragment
import com.matveichuk.smartkids.secondvoicefragment.SecondAnimalVoiceFragment
import com.matveichuk.smartkids.voicefragment.AnimalVoiceFragment

object DataMain {
    fun getData(): List<MainData> {
        return listOf(
            MainData(
                R.drawable.ic_animalvoice,
                "Голоса животных",
                AnimalVoiceFragment(),
                R.color.tea,
                R.drawable.tea_circle,
                "Узнай как разговаривают животные"
            ),
            MainData(
                R.drawable.ic_animalwhosay,
                "Кто сказал?",
                SecondAnimalVoiceFragment(),
                R.color.peach,
                R.drawable.peach_circle,
                "Угадай животное по звуку!"
            ),
            MainData(
                R.drawable.ic_cheese,
                "Что едят зверята",
                AnimalFoodFragment(),
                R.color.windows_eight,
                R.drawable.windows_circle,
                "Узнай чем питаются животные"
            ),
            MainData(
                R.drawable.ic_animaleats,
                "Что он ест?",
                SecondAnimalFoodFragment(),
                R.color.flower,
                R.drawable.flower_circle,
                "Угадай чем питаются животные"
            )
        )
    }
}