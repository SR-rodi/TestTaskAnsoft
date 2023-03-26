package com.example.testtaskansoft.feature.presentation.maps

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtaskansoft.core.provider.FusedClientProvider
import com.example.testtaskansoft.core.provider.LocationManagerProvider
import com.example.testtaskansoft.feature.domain.usecase.DataBaseAllDeliveryUseCase
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@SuppressLint("MissingPermission")
class MapsViewModel(
    private val fusedClientProvider: FusedClientProvider,
    private val locationManagerProvider: LocationManagerProvider,
    deliveryUseCase: DataBaseAllDeliveryUseCase
) : ViewModel() {

    val completeDelivery = deliveryUseCase.getAllDelivery()

    private val _isEnableGPS = MutableStateFlow(false)
    val isEnableGPS = _isEnableGPS.asStateFlow()

    private var googleMap: GoogleMap? = null
    private var needAddMarkerLocation = true
    private var needAddMarker = true

    val callback = OnMapReadyCallback { map ->
        googleMap = map
        if (needAddMarker) {
            needAddMarker = false
            drawMarkerToMap()
            checkEnableGPS()
        }
    }

    private val locationCallback by lazy {

        object : LocationCallback() {
            override fun onLocationResult(result: LocationResult) {
                result.lastLocation?.let { _ ->
                    googleMap?.isMyLocationEnabled = true
                    checkEnableGPS()
                }
            }
        }
    }

    private fun drawMarkerToMap() {
        viewModelScope.launch {
            completeDelivery.collect { listDelivery ->
                if (needAddMarkerLocation && listDelivery.isNotEmpty()) {
                    needAddMarkerLocation = false
                    val startLocation =
                        LatLng(
                            listDelivery.first().lat.toDouble(),
                            listDelivery.first().lon.toDouble()
                        )
                    googleMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(startLocation, 13f))
                }
                listDelivery.forEach { deliveryItem ->
                    val iconHUE = if (deliveryItem.isCompleted)
                        BitmapDescriptorFactory.HUE_GREEN
                    else
                        BitmapDescriptorFactory.HUE_RED
                    val baseLocation =
                        LatLng(deliveryItem.lat.toDouble(), deliveryItem.lon.toDouble())
                    googleMap?.addMarker(
                        MarkerOptions()
                            .position(baseLocation)
                            .icon(BitmapDescriptorFactory.defaultMarker(iconHUE))
                            .title(deliveryItem.address)
                    )
                }
            }
        }
    }


    fun addMarker() {
        needAddMarker = true
    }

    fun removeLocation() {
        checkEnableGPS()
        fusedClientProvider.removeLocation(locationCallback)
    }

    fun getNyLocation() {
        fusedClientProvider.getMyLocation(locationCallback)
    }

    fun checkEnableGPS(){
        _isEnableGPS.value = locationManagerProvider.checkEnableGPS()
    }
}