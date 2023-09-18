package com.example.nationalparkmeetup.composables

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.nationalparkmeetup.viewmodel.LocationViewModel
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDateTime
import java.time.ZoneOffset

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LocationMapView(viewModel: LocationViewModel) {
    val markerPoint by remember { mutableStateOf(LatLng(1.35, 103.87)) }
    var newMarkerPoint by remember {
        mutableStateOf(LatLng(0.00, 0.00))
    }
    val scope = rememberCoroutineScope()
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(markerPoint, 10f)
    }
    val expireDate = LocalDateTime.now().plusMinutes(60).toEpochSecond(ZoneOffset.UTC)
    val currentTime = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)
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
            icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN),
            flat = true
        ) {
            scope.launch(Dispatchers.IO) {
                for (i in (expireDate - currentTime) downTo 0) {
                    delay(1_000) // Delay for 1 second
                }
                withContext(Dispatchers.Main) {
                    if (markerPoint == newMarkerPoint) {
                        it.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                        it.isDraggable = false
                    }
                }
            }
            newMarkerPoint = it.position

            viewModel.insertLocation(markerPoint.latitude, markerPoint.latitude)
            Log.d("Q", "New coordinates: $markerPoint")
        }
    }
}

//@RequiresApi(Build.VERSION_CODES.O)
//@Preview
//@Composable
//fun LocationMapViewPreview() {
//    LocationMapView()
//}





