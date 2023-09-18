package com.example.nationalparkmeetup.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.nationalparkmeetup.model.LocationEntity

@Dao
interface LocationDao {
    @Insert
    fun insertLocation(location: LocationEntity)

    @Query("SELECT * FROM locations")
    fun getAllLocations(): List<LocationEntity>
}