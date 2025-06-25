package com.example.avarmil.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/** these are location points polled while travelling associated with [CompleteRoute] */
@Entity("route_points")
class RoutePoints(
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "associated_route_id") val associatedRouteId: Int,
    @ColumnInfo(name = "recorded_time") val recordedTime: Long,
    @ColumnInfo(name = "latitude") val latitude: Long,
    @ColumnInfo(name = "longitude") val longitude: Long,
)