package com.example.avarmil.ui.sections.view_route

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.avarmil.util.annotations.VerticalPreview
import com.example.avarmil.util.values.AverMilFonts
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
                                VerticalDivider(
                                    modifier = Modifier.fillMaxHeight(),
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
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