package com.example.avarmil.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/** this is the entire route. The rest of the associated details can be found in or extracted from [RoutePoints] */
@Entity(tableName = "complete_r0ute")
data class CompleteRoute(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "route_id") val routeId: Int,
    @ColumnInfo(name = "route_name") val routeName: String
)