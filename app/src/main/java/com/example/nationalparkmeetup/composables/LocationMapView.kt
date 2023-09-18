package com.example.nationalparkmeetup.composables

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun LocationMapView() {
    var markerPoint by remember { mutableStateOf(LatLng(1.35, 103.87)) }
    val scope = rememberCoroutineScope()
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(markerPoint, 10f)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    )
    {
        Marker(
            state = MarkerState(position = markerPoint),
            title = "Singapore",
            snippet = "Marker in Singapore",
            draggable = true,
            flat = true
        ){

            markerPoint = it.position
            Log.d("Q", "New coordinates: $markerPoint")
        }
    }
    }


@Preview
@Composable
fun LocationMapViewPreview() {
    LocationMapView()
}





