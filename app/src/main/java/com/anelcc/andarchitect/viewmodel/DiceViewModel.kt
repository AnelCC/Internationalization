package com.anelcc.andarchitect.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.anelcc.andarchitect.LOG_TAG

class DiceViewModel(app: Application): AndroidViewModel(app) {

    init {
        Log.i(LOG_TAG, "View model created")
    }
}