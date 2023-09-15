package com.example.nationalparkmeetup.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun Content(showButton: Boolean = true, onClick: () -> Unit) {
    if (showButton) {
        val enableLocation = remember { mutableStateOf(true) }
        if (enableLocation.value) {
            CustomDialogLocation(
                title = "Turn On Location Service",
                desc = "Explore the world without getting lost and keep the track of your location.\n\nGive this app a permission to proceed. If it doesn't work, then you'll have to do it manually from the settings.",
                enableLocation,
                onClick
            )
        }
    }
}