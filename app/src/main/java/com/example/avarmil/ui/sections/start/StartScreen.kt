package com.example.avarmil.ui.sections.start

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/** this is the first screen to open on start up. this handles all the permission handle */
object StartScreen {
    @Composable
    fun Screen(modifier: Modifier) {
        Scaffold(
            modifier = modifier,
            content = {
                Box(
                    modifier = Modifier
                        .padding(paddingValues = it)
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center,
                    content = {
                        Text(
                            text = "Pending"
                        )
                    }
                )
            }
        )
    }
}