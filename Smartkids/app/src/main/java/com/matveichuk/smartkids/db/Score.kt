package com.matveichuk.smartkids.db

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "score_table")
data class Score(@PrimaryKey @ColumnInfo(name = "score") val score: Int)
