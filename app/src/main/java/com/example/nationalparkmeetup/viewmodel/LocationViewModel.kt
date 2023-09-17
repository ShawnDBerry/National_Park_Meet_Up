package com.example.nationalparkmeetup.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.nationalparkmeetup.modal.LocationDao
import com.example.nationalparkmeetup.modal.LocationDatabase

class LocationViewModel(application: Application) : AndroidViewModel(application) {
    private val locationDao: LocationDao

    init {
        val database = LocationDatabase.getDatabase(application)
        locationDao = database.locationDao()
    }

    suspend fun insertLocation(latitude: Double, longitude: Double) {
        locationDao.insertLocation(LocationEntity(latitude = latitude, longitude = longitude))
    }

    suspend fun getAllLocations(): List<LocationEntity> {
        return locationDao.getAllLocations()
    }
}