package com.example.testtaskansoft.core.provider

import com.google.android.gms.location.LocationCallback

interface FusedClientProvider {

    fun getMyLocation(locationCallback: LocationCallback)

    fun removeLocation(locationCallback: LocationCallback)
}