package com.example.testtaskansoft.core.provider.impl

import android.annotation.SuppressLint
import android.content.Context
import android.os.Looper
import com.example.testtaskansoft.core.provider.FusedClientProvider
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority

class FusedClientProviderImpl(context:Context): FusedClientProvider {

    private val fusedClient: FusedLocationProviderClient
    = LocationServices.getFusedLocationProviderClient(context)

    @SuppressLint("MissingPermission")
    override fun getMyLocation(locationCallback:LocationCallback) {
        val request = LocationRequest
            .Builder(Priority.PRIORITY_LOW_POWER, 1_000)
            .build()
        fusedClient.requestLocationUpdates(request, locationCallback, Looper.getMainLooper())
    }

    override fun removeLocation(locationCallback:LocationCallback) {
        fusedClient.removeLocationUpdates(locationCallback)
    }
}