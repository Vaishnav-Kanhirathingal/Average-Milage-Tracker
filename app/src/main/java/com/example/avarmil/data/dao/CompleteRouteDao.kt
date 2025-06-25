package com.example.avarmil.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.avarmil.data.models.CompleteRoute

@Dao
interface CompleteRouteDao {
    @Query("SELECT * FROM complete_route")
    fun getAll():List<CompleteRoute>
}