package com.matveichuk.smartkids.db

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class ScoreViewModel(private val repository: ScoreRepository) : ViewModel() {

    val allScore: LiveData<List<Score>> = repository.allScore.asLiveData()

    fun insert(score: Score) = viewModelScope.launch {
        repository.insert(score)

    }

    fun update(score: Score) = viewModelScope.launch {
        repository.updateScore(score)
    }

}
