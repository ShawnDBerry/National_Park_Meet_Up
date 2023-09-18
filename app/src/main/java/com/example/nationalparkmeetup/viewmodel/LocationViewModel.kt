package com.example.nationalparkmeetup.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import com.example.nationalparkmeetup.dao.LocationDao
import com.example.nationalparkmeetup.database.LocationDatabase
import com.example.nationalparkmeetup.model.LocationEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(application: Application) : AndroidViewModel(application) {
    private val locationDao: LocationDao

    init {
        val db = Room.databaseBuilder(
            application,
            LocationDatabase::class.java, "locations"
        ).build()
        locationDao = db.locationDao()
    }

  suspend  fun insertLocation(latitude: Double, longitude: Double) {
        locationDao.insertLocation(LocationEntity(id = 0, latitude = latitude, longitude = longitude))
    }

   suspend fun getAllLocations(): List<LocationEntity> {
        return locationDao.getAllLocations()
    }
}