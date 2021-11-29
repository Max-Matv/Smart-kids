package com.matveichuk.smartkids.db

import android.app.Application
import com.matveichuk.smartkids.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ScoreApplication : Application() {

    override fun onCreate() {
        super.onCreate()
       startKoin{
           androidLogger()
           androidContext(this@ScoreApplication)
           modules(
               db,
               dbViewModel,
               repository,
               secondViewModel,
               networkModule,
//               catViewModel
           )
       }
    }
}