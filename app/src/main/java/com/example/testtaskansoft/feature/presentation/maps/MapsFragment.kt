package com.example.testtaskansoft.feature.presentation.maps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.testtaskansoft.R
import com.example.testtaskansoft.core.base.BaseFragment
import com.example.testtaskansoft.databinding.FragmentMapsBinding
import com.example.testtaskansoft.feature.domain.model.Delivery
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.koin.androidx.viewmodel.ext.android.viewModel

class MapsFragment : BaseFragment<FragmentMapsBinding>() {

    override fun initBinding(inflater: LayoutInflater) = FragmentMapsBinding.inflate(inflater)

    private val viewModel by viewModel<MapsViewModel>()

    private val callback by lazy { creteOnMapReadyCallback() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    private fun drawMarkerToMap(googleMap: GoogleMap, list: List<Delivery>) =
        list.forEach { deliveryItem ->
            val baseLocation =
                LatLng(deliveryItem.lat.toDouble(), deliveryItem.lon.toDouble())
            googleMap.addMarker(
                MarkerOptions().position(baseLocation).title(deliveryItem.address)
            )
        }

    private fun creteOnMapReadyCallback() = OnMapReadyCallback { googleMap ->
        flowListener(viewModel.completeDelivery) { listDelivery ->
            if (listDelivery.isNotEmpty()) {
                drawMarkerToMap(googleMap, listDelivery)
                val baseLocation = LatLng(48.705177, 44.508064)
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(baseLocation, 11f))
            }
        }
    }

}