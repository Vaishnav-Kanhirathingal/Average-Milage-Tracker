package com.example.avarmil.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.avarmil.data.dao.CompleteRouteDao
import com.example.avarmil.data.dao.RoutePointDao
import com.example.avarmil.data.models.CompleteRoute
import com.example.avarmil.data.models.RoutePoints

@Database(
    entities = [CompleteRoute::class, RoutePoints::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun completeRouteDao(): CompleteRouteDao
    abstract fun routePointDao(): RoutePointDao
}