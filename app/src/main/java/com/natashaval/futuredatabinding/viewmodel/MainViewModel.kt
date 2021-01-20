package com.natashaval.futuredatabinding.viewmodel

import androidx.lifecycle.ViewModel
import com.natashaval.futuredatabinding.model.User

/**
 * Created by natasha.santoso on 20/01/21.
 */
class MainViewModel : ViewModel() {
    val user = User("Natasha", "Santoso")
    var score = 0
        private set

    fun updateScore(value: Int) {
        score += value
    }
}