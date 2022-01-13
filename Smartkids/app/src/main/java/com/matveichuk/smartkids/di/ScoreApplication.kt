package com.matveichuk.smartkids.di

import android.app.Application
import com.matveichuk.smartkids.AnimaFood.FoodModule.foodViewModel
import com.matveichuk.smartkids.SecondAnimalFood.SecondFoodModule.secondFoodViewModel
import com.matveichuk.smartkids.db.dbModule.db
import com.matveichuk.smartkids.db.dbModule.dbViewModel
import com.matveichuk.smartkids.db.dbModule.repository
import com.matveichuk.smartkids.di.*
import com.matveichuk.smartkids.mainfragment.MainModule.mainViewModel
import com.matveichuk.smartkids.secondvoicefragment.SecondModule.secondViewModel
import com.matveichuk.smartkids.voicefragment.VoiceModule.voiceViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ScoreApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ScoreApplication)
            modules(
                db,
                dbViewModel,
                repository,
                secondViewModel,
                mainViewModel,
                voiceViewModel,
                foodViewModel,
                secondFoodViewModel
            )
        }
    }
}