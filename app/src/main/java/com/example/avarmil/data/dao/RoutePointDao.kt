package com.example.avarmil.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.avarmil.data.models.RoutePoints

@Dao
interface RoutePointDao {
    @Query("SELECT * FROM route_points WHERE associated_route_id = :routeId")
    fun getByRouteId(routeId: Int): List<RoutePoints>
}