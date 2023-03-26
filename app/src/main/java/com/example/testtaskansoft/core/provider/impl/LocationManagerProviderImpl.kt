package com.example.testtaskansoft.core.provider.impl

import android.content.Context
import android.location.LocationManager
import com.example.testtaskansoft.core.provider.LocationManagerProvider

class LocationManagerProviderImpl(context: Context) : LocationManagerProvider {

    private val locationManager =
        context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    override fun checkEnableGPS() = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)

}
