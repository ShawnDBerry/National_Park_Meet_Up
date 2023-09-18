package com.example.nationalparkmeetup.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nationalparkmeetup.dao.LocationDao
import com.example.nationalparkmeetup.model.LocationEntity

@Database(entities = [LocationEntity::class], version = 1, exportSchema = false)
abstract class LocationDatabase : RoomDatabase() {
    abstract fun locationDao(): LocationDao
}