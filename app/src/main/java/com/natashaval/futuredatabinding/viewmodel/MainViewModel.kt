package com.natashaval.futuredatabinding.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.natashaval.futuredatabinding.model.User

/**
 * Created by natasha.santoso on 20/01/21.
 */
class MainViewModel : ViewModel() {
    val user = User("Natasha", "Santoso")
//    var score = 0
//        private set

    private var _newScore: MutableLiveData<Int> = MutableLiveData(0)
    val newScore get() = _newScore

    fun updateScore(value: Int) {
//        score += value
        newScore.value = (newScore.value ?: 0) + value
    }
}