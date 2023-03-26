package com.example.testtaskansoft.feature.presentation.maps

import android.content.Context
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import com.example.testtaskansoft.R
import com.example.testtaskansoft.core.base.BaseFragment
import com.example.testtaskansoft.core.checkPermissions
import com.example.testtaskansoft.core.createLauncher
import com.example.testtaskansoft.databinding.FragmentMapsBinding
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.SupportMapFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class MapsFragment : BaseFragment<FragmentMapsBinding>() {

    override fun initBinding(inflater: LayoutInflater) = FragmentMapsBinding.inflate(inflater)

    private val viewModel by viewModel<MapsViewModel>()

    private val locationManager by lazy {
        requireContext().getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    private val launcher = createLauncher { viewModel.getNyLocation() }

    override fun onStart() {
        super.onStart()
        checkPermissions(launcher) { viewModel.getNyLocation() }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.addMarker()

        flowListener(viewModel.isEnableGPS){
            binding.gpsError.isVisible = !it
        }

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(viewModel.callback)

        mapFragment?.getMapAsync { map ->
            map.uiSettings.apply {
                isMyLocationButtonEnabled = true
                isZoomControlsEnabled = true
            }
        }
    }

    override fun onStop() {
        super.onStop()
        viewModel.removeLocation()
    }

}