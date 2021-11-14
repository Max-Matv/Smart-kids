package com.matveichuk.smartkids.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ScoreDao {
    @Query("SELECT score FROM score_table")
    fun getScore(): Flow<List<Score>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(score: Score)

    @Update
    suspend fun updateScore(score: Score)

}
