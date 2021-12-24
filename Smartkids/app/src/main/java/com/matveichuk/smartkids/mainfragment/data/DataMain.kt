package com.matveichuk.smartkids.mainfragment.data

import com.matveichuk.smartkids.R
import com.matveichuk.smartkids.rightplacefragment.RightPlaceFragment
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
                R.drawable.ic_figure,
                "Фигуры",
                RightPlaceFragment(),
                R.color.windows_eight,
                R.drawable.windows_circle,
                "Расставь фигуры по своим местам"
            )
        )
    }
}