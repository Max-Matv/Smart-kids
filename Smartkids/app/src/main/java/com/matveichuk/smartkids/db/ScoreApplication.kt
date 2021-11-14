package com.matveichuk.smartkids.db

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ScoreApplication : Application() {
    private val applicationScope = CoroutineScope(SupervisorJob())
    private val database by lazy { ScoreDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { ScoreRepository(database.scoreDao()) }

    override fun onCreate() {
        super.onCreate()
        //start koin
    }
}