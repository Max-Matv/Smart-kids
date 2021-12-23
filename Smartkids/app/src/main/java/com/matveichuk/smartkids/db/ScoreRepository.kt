package com.matveichuk.smartkids.db



import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow


class ScoreRepository(private val scoreDao: ScoreDao) {
    val allScore: Flow<List<Score>> = scoreDao.getScore()

    suspend fun insert(score: Score) {
        scoreDao.insert(score)
    }

    suspend fun updateScore(score: Score) {
        scoreDao.updateScore(score)
    }
}