package com.example.avarmil.util.values

import androidx.compose.foundation.layout.sizeIn
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

object CustomSharedValues {
    val minimumTouchSize = 48.dp

    fun Modifier.setSizeLimitation() {
        this.sizeIn(
            minWidth = minimumTouchSize,
            minHeight = minimumTouchSize
        )
    }
}