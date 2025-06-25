package com.example.avarmil.util.values

import androidx.compose.foundation.layout.sizeIn
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

object CustomSharedValues {
    val minimumTouchSize = 48.dp
    val buttonCornerSize=8.dp

    fun Modifier.setSizeLimitation(): Modifier {
        return this.sizeIn(
            minWidth = minimumTouchSize,
            minHeight = minimumTouchSize
        )
    }
}