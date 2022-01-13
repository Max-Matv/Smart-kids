package com.matveichuk.smartkids.db.dbModule

import android.app.Application
import androidx.room.Room
import com.matveichuk.smartkids.db.ScoreDao
import com.matveichuk.smartkids.db.ScoreDatabase
import com.matveichuk.smartkids.db.ScoreRepository
import com.matveichuk.smartkids.db.ScoreViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val db = module {
    fun provideDataBase(application: Application): ScoreDatabase {
        return Room.databaseBuilder(application, ScoreDatabase::class.java, "SCOREDB")
            .fallbackToDestructiveMigration()
            .build()
    }
    fun provideDao(database: ScoreDatabase): ScoreDao {
        return  database.scoreDao()
    }
    single { provideDataBase(androidApplication()) }
    single { provideDao(get()) }
}
val dbViewModel = module {
    viewModel { ScoreViewModel(get()) }
}
val repository = module {
    single { ScoreRepository(get()) }
}