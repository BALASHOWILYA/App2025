package com.example.myapplication.presentaition.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LogInViewModel: ViewModel() {

    private val _state = MutableStateFlow(FirstState())
    val state = _state.asStateFlow()



}

class FirstState