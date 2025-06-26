package com.example.avarmil.ui.sections.start

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.avarmil.ui.shared.SimpleRoundedCornerButton
import com.example.avarmil.util.values.CustomSharedValues.setSizeLimitation

/** this is the first screen to open on start up. this handles all the permission handle */
object StartScreen {
    @Composable
    fun Screen(
        modifier: Modifier,
        toHomeScreen: () -> Unit
    ) {
        Scaffold(
            modifier = modifier,
            content = {
                Column(
                    modifier = Modifier
                        .padding(paddingValues = it)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(
                        space = 4.dp,
                        alignment = Alignment.CenterVertically
                    ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    content = {
                        Text(
                            text = "Pending"
                        )
                        SimpleRoundedCornerButton(
                            modifier = Modifier
                                .setSizeLimitation()
                                .padding(horizontal = 16.dp),
                            text = "By-Pass (TODO)",
                            onClick = toHomeScreen
                        )
                    }
                )
            }
        )
    }
}