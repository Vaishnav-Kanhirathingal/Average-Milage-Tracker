package com.example.avarmil.util.services

import android.app.Service
import android.content.Intent
import android.location.Location
import android.os.IBinder
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority

class TrackingService : Service() {
    companion object {
        const val INTENT_FILTER = "DISTANCE_UPDATE"
        const val TOTAL_DISTANCE_KEY = "total_distance_key"
    }

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var locationRequest: LocationRequest
    private var lastValidLocation: Location? = null
    private var totalDistance = 0.0

    private val locationCallback = object : LocationCallback() {
        override fun onLocationResult(result: LocationResult) {
            val location = result.lastLocation ?: return
            if ((location.accuracy <= 20) && (lastValidLocation != null)) {
                val distance = lastValidLocation!!.distanceTo(location) // uses Haversine internally
                totalDistance += distance
                sendBroadcast(Intent(INTENT_FILTER).putExtra(TOTAL_DISTANCE_KEY, totalDistance))
                lastValidLocation = location
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        locationRequest = LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 5_000L)
            .setMinUpdateDistanceMeters(10.0f)
            .build()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

//        startForeground(1)
//
//        fusedLocationProviderClient.requestLocationUpdates(
//            locationRequest,
//
//            )
        return START_STICKY
    }

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}