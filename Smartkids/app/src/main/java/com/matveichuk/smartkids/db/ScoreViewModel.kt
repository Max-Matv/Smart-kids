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

class ScoreViewModelFactory(private val repository: ScoreRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScoreViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ScoreViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}