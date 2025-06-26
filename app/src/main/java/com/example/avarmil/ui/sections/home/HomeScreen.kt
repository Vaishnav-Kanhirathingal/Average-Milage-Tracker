package com.example.avarmil.ui.sections.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.avarmil.ui.shared.SimpleRoundedCornerButton
import com.example.avarmil.util.annotations.VerticalPreview
import com.example.avarmil.util.values.CustomSharedValues
import com.example.avarmil.util.values.CustomSharedValues.setSizeLimitation
import com.google.maps.android.compose.GoogleMap

object HomeScreen {
    @Composable
    fun Screen(modifier: Modifier) {
        Scaffold(
            modifier = modifier,
            content = {
                Column(
                    modifier = Modifier
                        .padding(paddingValues = it)
                        .padding(bottom = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(space = 8.dp),
                    content = {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(weight = 1f)
                                .padding(
                                    start = 16.dp,
                                    end = 16.dp,
                                    top = 16.dp
                                )
                                .clip(shape = RoundedCornerShape(size = CustomSharedValues.buttonCornerSize))
                                .background(
                                    color = Color(
                                        red = 0,
                                        green = 0,
                                        blue = 0,
                                        alpha = 0x18
                                    )
                                ),
                            content = {
                                GoogleMap(
                                    modifier = Modifier.fillMaxSize()
                                )
                                Icon(
                                    modifier = Modifier
                                        .align(alignment = Alignment.TopEnd)
                                        .padding(all = 16.dp)
                                        .background(
                                            color = Color(0, 0, 0, 0x18),
                                            shape = CircleShape
                                        )
                                        .padding(all = 4.dp),
                                    imageVector = Icons.Default.PlayArrow,
                                    contentDescription = null
                                )
                            }
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            horizontalArrangement = Arrangement.spacedBy(
                                space = 8.dp,
                                alignment = Alignment.CenterHorizontally
                            ),
                            verticalAlignment = Alignment.CenterVertically,
                            content = {
                                SimpleRoundedCornerButton(
                                    modifier = Modifier
                                        .setSizeLimitation()
                                        .weight(weight = 1f),
                                    onClick = { TODO() },
                                    text = "Pause/Resume"
                                )
                                SimpleRoundedCornerButton(
                                    modifier = Modifier
                                        .setSizeLimitation()
                                        .weight(weight = 1f),
                                    onClick = { TODO() },
                                    text = "End"
                                )
                            }
                        )
                    }
                )
            }
        )
    }
}

@VerticalPreview
@Composable
private fun HomeScreenPrev() {
    HomeScreen.Screen(modifier = Modifier.fillMaxSize())
}