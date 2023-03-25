package com.example.testtaskansoft.feature.presentation.maps

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import com.example.testtaskansoft.R
import com.example.testtaskansoft.core.base.BaseFragment
import com.example.testtaskansoft.core.checkPermissions
import com.example.testtaskansoft.core.createLauncher
import com.example.testtaskansoft.databinding.FragmentMapsBinding
import com.example.testtaskansoft.feature.domain.model.Delivery
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
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

    private lateinit var fusedClient: FusedLocationProviderClient

    private val launcher = createLauncher { viewModel.addMyLocation() }

    override fun onStart() {
        super.onStart()
        checkPermissions(launcher) {
            viewModel.addMyLocation()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.addMarker()

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(viewModel.callback)

        mapFragment?.getMapAsync { map ->
            map.uiSettings.apply {
                isMyLocationButtonEnabled = true
                isZoomControlsEnabled = true
            }
        }

        viewModel.setClient(LocationServices.getFusedLocationProviderClient(requireContext()))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.removeLocation()
    }

}