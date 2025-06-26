package com.example.avarmil.ui.sections.start

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow

@HiltViewModel
class StartScreenViewModel : ViewModel() {
    val title: MutableStateFlow<String> = MutableStateFlow(value = "")
}