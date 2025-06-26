package com.example.avarmil.ui.sections.start

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.avarmil.ui.shared.SimpleRoundedCornerButton
import com.example.avarmil.util.annotations.VerticalPreview
import com.example.avarmil.util.values.AverMilFonts
import com.example.avarmil.util.values.CustomSharedValues
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.accompanist.permissions.rememberPermissionState

/** this is the first screen to open on start up. this handles all the permission handle */
object StartScreen {
    @Composable
    fun Screen(
        modifier: Modifier,
        toHomeScreen: () -> Unit,
        startScreenViewModel: StartScreenViewModel
    ) {
        Scaffold(
            modifier = modifier,
            content = {
                PermissionGuideDialog(
                    dismiss = { TODO() }
                )
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
                        TextField(
                            value = startScreenViewModel.title.collectAsState().value,
                            onValueChange = { str -> startScreenViewModel.title.value = str }
                        )
                        SimpleRoundedCornerButton(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            text = "By-Pass (TODO)",
                            onClick = { TODO("toHomeScreen") }
                        )
                    }
                )
            }
        )
    }

    @OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
    @Composable
    fun PermissionGuideDialog(
        dismiss: () -> Unit
    ) {
        BasicAlertDialog(
            modifier = Modifier.fillMaxWidth(),
            onDismissRequest = {},
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = MaterialTheme.colorScheme.surface,
                            shape = RoundedCornerShape(size = CustomSharedValues.dialogCornerSize)
                        )
                        .padding(
                            horizontal = 16.dp,
                            vertical = 16.dp
                        ),
                    verticalArrangement = Arrangement.spacedBy(
                        space = 8.dp,
                        alignment = Alignment.CenterVertically
                    ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    content = {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            text = "Permissions pending",
                            fontFamily = AverMilFonts.font,
                            fontWeight = FontWeight.Bold,
                            fontSize = AverMilFonts.Title.medium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        val locationPermissionState = rememberMultiplePermissionsState(
                            permissions = listOf(
                                android.Manifest.permission.ACCESS_FINE_LOCATION,
                                android.Manifest.permission.ACCESS_COARSE_LOCATION
                            )
                        )
                        if (!locationPermissionState.allPermissionsGranted) {
                            RationaleCard(
                                modifier = Modifier.fillMaxWidth(),
                                phasesToClear = PhasesToClear.LOCATION_PERMISSION,
                                onClick = locationPermissionState::launchMultiplePermissionRequest

                            )
                        }
                        RationaleCard(
                            modifier = Modifier.fillMaxWidth(),
                            phasesToClear = PhasesToClear.BATTERY_OPTIMIZATION,
                            onClick = { TODO() }
                        )

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                            val notificationPermissionState = rememberPermissionState(
                                permission = android.Manifest.permission.POST_NOTIFICATIONS
                            )
                            if (!notificationPermissionState.status.isGranted) {
                                RationaleCard(
                                    modifier = Modifier.fillMaxWidth(),
                                    phasesToClear = PhasesToClear.NOTIFICATION_PERMISSION,
                                    onClick = notificationPermissionState::launchPermissionRequest
                                )
                            }
                        }
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            text = "*These permissions are necessary for correct functionality of the application",
                            fontFamily = AverMilFonts.font,
                            fontWeight = FontWeight.Medium,
                            fontSize = AverMilFonts.Label.medium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                )
            }
        )
    }

    @Composable
    fun RationaleCard(
        modifier: Modifier,
        phasesToClear: PhasesToClear,
        onClick: () -> Unit
    ) {
        Row(
            modifier = modifier
                .background(
                    color = MaterialTheme.colorScheme.surfaceContainer,
                    shape = RoundedCornerShape(size = CustomSharedValues.buttonCornerSize)
                )
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(space = 8.dp),
            content = {
                Column(
                    modifier = Modifier.weight(weight = 1f),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center,
                    content = {
                        Text(
                            text = phasesToClear.title,
                            fontFamily = AverMilFonts.font,
                            fontWeight = FontWeight.Bold,
                            fontSize = AverMilFonts.Body.medium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = phasesToClear.rationale,
                            fontFamily = AverMilFonts.font,
                            fontWeight = FontWeight.Medium,
                            fontSize = AverMilFonts.Label.medium,
                            lineHeight = AverMilFonts.Label.medium,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                    }
                )
                SimpleRoundedCornerButton(
                    modifier = Modifier,
                    text = "Verify",
                    onClick = onClick
                )
            }
        )
    }
}

@VerticalPreview
@Composable
fun PermissionGuideDialogPrev() {
    StartScreen.PermissionGuideDialog(
        dismiss = {}
    )
}

enum class PhasesToClear(
    val title: String,
    val rationale: String,
) {
    LOCATION_PERMISSION(
        title = "Location permission",
        rationale = "Required to be able to track precise geo-location for distance tracking",
    ),
    BATTERY_OPTIMIZATION(
        title = "Exclusion from battery optimization",
        rationale = "Required for the service to continue running while tha app is closed and the system does not close the background task responsible for distance tracking."
    ),
    NOTIFICATION_PERMISSION(
        title = "Notification permission",
        rationale = "Notification permission is required so that a persistent notification with the trip details can be displayed"
    )
}