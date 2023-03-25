package com.example.testtaskansoft.feature.presentation.maps

import android.annotation.SuppressLint
import android.os.Looper
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtaskansoft.di.viewModelModule
import com.example.testtaskansoft.feature.domain.model.Delivery
import com.example.testtaskansoft.feature.domain.repository.LocalDeliveryRepository
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@SuppressLint("MissingPermission")
class MapsViewModel(repository: LocalDeliveryRepository) : ViewModel() {

    private lateinit var fusedClient: FusedLocationProviderClient

    val completeDelivery = repository.getDeliveryByCompleted(false)

    private var googleMap: GoogleMap? = null
    private var needAddMarkerLocation = true
    private var needAddMarker = true

    val callback = OnMapReadyCallback { map -> googleMap = map }

    private val locationCallback by lazy {

        object : LocationCallback() {
            override fun onLocationResult(result: LocationResult) {
                result.lastLocation?.let { location ->
                    val myLocation = LatLng(location.latitude, location.longitude)
                    if (needAddMarkerLocation) {
                        needAddMarkerLocation = false
                        googleMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(myLocation, 13f))
                    }
                    if (needAddMarker) {
                        needAddMarker = false
                        drawMarkerToMap()
                    }
                }
            }
        }
    }

    private fun drawMarkerToMap() {
        viewModelScope.launch {
            googleMap?.isMyLocationEnabled = true
            completeDelivery.collect { listDelivery ->
                listDelivery.forEach { deliveryItem ->
                    val baseLocation =
                        LatLng(deliveryItem.lat.toDouble(), deliveryItem.lon.toDouble())
                    googleMap?.addMarker(
                        MarkerOptions().position(baseLocation).title(deliveryItem.address)
                    )
                }
            }
        }
    }

    fun addMyLocation() {
        val request = LocationRequest.Builder(Priority.PRIORITY_LOW_POWER, 1_000).build()
        fusedClient.requestLocationUpdates(request, locationCallback, Looper.getMainLooper())
    }

    fun addMarker() {
        needAddMarker = true
    }

    fun removeLocation() {
        fusedClient.removeLocationUpdates(locationCallback)
    }

    fun setClient(client: FusedLocationProviderClient) {
        fusedClient = client
    }

}