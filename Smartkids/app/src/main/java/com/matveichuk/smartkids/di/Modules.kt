package com.matveichuk.smartkids.di

import android.app.Application
import androidx.room.Room
import com.matveichuk.smartkids.AnimalMaps.AnimalLocationVIewModel.AnimalLocationViewModel
import com.matveichuk.smartkids.Apifragment.api.ServiceBuilder
import com.matveichuk.smartkids.db.ScoreDao
import com.matveichuk.smartkids.db.ScoreDatabase
import com.matveichuk.smartkids.db.ScoreRepository
import com.matveichuk.smartkids.db.ScoreViewModel
import com.matveichuk.smartkids.mainfragment.viewmodel.MainViewModel
import com.matveichuk.smartkids.secondvoicefragment.viewmodel.SecondVoiceViewModel
import com.matveichuk.smartkids.voicefragment.viewmodel.VoiceViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


