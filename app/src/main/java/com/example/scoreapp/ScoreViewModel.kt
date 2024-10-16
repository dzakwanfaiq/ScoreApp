package com.example.scoreapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {

    private val _scoreA = MutableLiveData(0)
    val scoreA: LiveData<Int> get() = _scoreA

    private val _scoreB = MutableLiveData(0)
    val scoreB: LiveData<Int> get() = _scoreB

    fun incrementScoreA() {
        _scoreA.value = (_scoreA.value ?: 0) + 1
    }

    fun incrementScoreB() {
        _scoreB.value = (_scoreB.value ?: 0) + 1
    }

    // Menentukan tipe parameter secara eksplisit
    val winner: LiveData<String> = Transformations.map(_scoreA) { scoreAValue: Int ->
        when {
            scoreAValue >= 10 -> "Tim A Menang!"
            _scoreB.value ?: 0 >= 10 -> "Tim B Menang!"
            else -> ""
        }
    }
}
