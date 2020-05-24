package com.anelcc.andarchitect.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.anelcc.andarchitect.DiceHelper
import com.anelcc.andarchitect.LOG_TAG
import com.anelcc.andarchitect.R

class DiceViewModel(app: Application): AndroidViewModel(app) {
    val headline = MutableLiveData<String>()
    val dice = MutableLiveData<IntArray>()
    private val context = app

    init {
        Log.i(LOG_TAG, "View model created")
        headline.value = context.getString(R.string.welcome)
        dice.value = intArrayOf(6, 6, 6, 6, 6)
    }

    fun rollDice() {
        dice.value = DiceHelper.rollDice()
        headline.value = DiceHelper.evaluateDice(context, dice.value)
    }
}