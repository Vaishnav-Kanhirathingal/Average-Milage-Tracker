package com.example.avarmil.ui.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.avarmil.util.values.AverMilFonts
import com.example.avarmil.util.values.CustomSharedValues
import com.example.avarmil.util.values.CustomSharedValues.setSizeLimitation

@Composable
fun SimpleRoundedCornerButton(
    modifier: Modifier,
    text: String,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .setSizeLimitation()
            .clip(shape = RoundedCornerShape(size = CustomSharedValues.buttonCornerSize))
            .background(color = MaterialTheme.colorScheme.primaryContainer)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center,
        content = {
            Text(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                textAlign = TextAlign.Center,
                text = text,
                fontFamily = AverMilFonts.font,
                fontSize = AverMilFonts.Body.medium,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    )
}