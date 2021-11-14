package com.matveichuk.smartkids.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Score::class], version = 1, exportSchema = false)
abstract class ScoreDatabase : RoomDatabase() {

    abstract fun scoreDao(): ScoreDao

    private class ScoreDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let{ database ->
                scope.launch {
                    populateDatabase(database.scoreDao())
                }
            }
        }
        suspend fun populateDatabase(scoreDao: ScoreDao) {
            var score = Score(0)
          scoreDao.insert(score)
        }
    }

    companion object{
        @Volatile
        private var INSTANCE: ScoreDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): ScoreDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance =
                    Room.databaseBuilder(
                        context.applicationContext,
                        ScoreDatabase::class.java,
                        "score_database"
                    ).addCallback(ScoreDatabaseCallback(scope))
                        .fallbackToDestructiveMigration()
                        .build()
                INSTANCE = instance
                instance
            }
        }
    }

}