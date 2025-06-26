package com.example.avarmil.ui.sections.view_route

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.avarmil.ui.shared.SimpleRoundedCornerButton
import com.example.avarmil.util.annotations.VerticalPreview
import com.example.avarmil.util.values.AverMilFonts
import com.example.avarmil.util.values.CustomSharedValues
import com.example.avarmil.util.values.CustomSharedValues.setSizeLimitation
import com.google.maps.android.compose.GoogleMap

object ViewRouteScreen {
    @Composable
    fun Screen(modifier: Modifier) {
        Scaffold(
            modifier = modifier,
            content = {
                Column(
                    modifier = Modifier
                        .padding(paddingValues = it)
                        .fillMaxSize()
                        .verticalScroll(state = rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(
                        space = 4.dp,
                        alignment = Alignment.CenterVertically
                    ),
                    content = {
                        GoogleMap(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                                .aspectRatio(ratio = 1f)
                                .clip(shape = RoundedCornerShape(size = CustomSharedValues.buttonCornerSize))
                                .background(
                                    color = Color(
                                        red = 0,
                                        green = 0,
                                        blue = 0,
                                        alpha = 0x18
                                    )
                                )
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                                .background(
                                    color = MaterialTheme.colorScheme.surfaceContainer,
                                    shape = RoundedCornerShape(size = 8.dp)
                                )
                                .padding(
                                    horizontal = 16.dp,
                                    vertical = 8.dp
                                ),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            content = {
                                Column(
                                    modifier = Modifier.weight(weight = 2f),
                                    content = {
                                        Text(
                                            modifier = Modifier.fillMaxWidth(),
                                            text = "TOTAL time (TODO)",
                                            fontFamily = AverMilFonts.font,
                                            fontSize = AverMilFonts.Title.medium,
                                            fontWeight = FontWeight.SemiBold,
                                            color = MaterialTheme.colorScheme.onSurface
                                        )
                                        Text(
                                            modifier = Modifier.fillMaxWidth(),
                                            text = "Start (TODO) - End (TODO)",
                                            fontFamily = AverMilFonts.font,
                                            fontSize = AverMilFonts.Label.medium,
                                            fontWeight = FontWeight.SemiBold,
                                            color = MaterialTheme.colorScheme.onSurface
                                        )
                                    }
                                )
                                Box(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .width(width = 1.dp)
                                        .background(color = MaterialTheme.colorScheme.primary),
                                )
                                Text(
                                    modifier = Modifier.weight(weight = 1f),
                                    text = "TOTAL Distance (TODO)",
                                    fontFamily = AverMilFonts.font,
                                    fontSize = AverMilFonts.Title.medium,
                                    fontWeight = FontWeight.SemiBold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        )

                        SimpleRoundedCornerButton(
                            modifier = Modifier
                                .setSizeLimitation()
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            text = "Back",
                            onClick = { TODO() }
                        )
                    }
                )
            }
        )
    }
}

@VerticalPreview
@Composable
fun ViewRouteScreenPreview() {
    ViewRouteScreen.Screen(modifier = Modifier.fillMaxSize())
}