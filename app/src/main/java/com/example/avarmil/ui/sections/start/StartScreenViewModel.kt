package com.example.avarmil.ui.sections.start

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow

@HiltViewModel
class StartScreenViewModel @Inject constructor() : ViewModel() {
    val title: MutableStateFlow<String> = MutableStateFlow(value = "")
}