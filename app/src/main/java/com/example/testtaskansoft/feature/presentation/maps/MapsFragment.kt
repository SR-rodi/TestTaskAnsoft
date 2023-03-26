package com.example.testtaskansoft.feature.presentation.maps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
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