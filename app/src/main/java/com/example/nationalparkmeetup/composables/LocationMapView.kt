package com.example.nationalparkmeetup.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun LocationMapView() {
//    var mapView by remember { mutableStateOf<MapView?>(null) }
//    val context = LocalContext.current
//    // Initialize the map view
//    DisposableEffect(Unit) {
//        val map = MapView(context)
//        mapView = map
//
//        // Handle Google Play Services availability
//        try {
//            GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context)
//        } catch (e: GooglePlayServicesNotAvailableException) {
//            // Handle Google Play Services not available
//            // You can show an error message or take appropriate action here.
//        }
//
//        map.getMapAsync { googleMap ->
//            googleMap.apply {
//                // Add a marker to the map (you can customize this)
//                addMarker(
//                    MarkerOptions()
//                        .position(LatLng(0.0, 0.0)) // Default marker position
//                        .title("Marker")
//                )
//
//                // Move the camera to the marker's position (you can customize this)
//                moveCamera(
//                    CameraUpdateFactory.newLatLngZoom(LatLng(0.0, 0.0), 15f)
//                )
//            }
//        }
//
//        onDispose {
//            mapView?.onDestroy()
//        }
//    }
//
//    // Display the map
//    Box(
//        modifier = Modifier.fillMaxSize()
//    ) {
//        mapView?.let { map ->
//            AndroidView(
//                factory = { map }
//            )
//        }
//    }
    val singapore = LatLng(1.35, 103.87)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 10f)
    }
    val uiSettings by remember { mutableStateOf(MapUiSettings()) }
    val properties by remember {
        mutableStateOf(MapProperties(mapType = MapType.SATELLITE))
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        properties = properties,
        uiSettings = uiSettings
    ) {
        Marker(
            state = MarkerState(position = singapore),
            title = "Singapore",
            snippet = "Marker in Singapore"
        )
    }
    }


@Preview
@Composable
fun LocationMapViewPreview() {
    LocationMapView()
}





