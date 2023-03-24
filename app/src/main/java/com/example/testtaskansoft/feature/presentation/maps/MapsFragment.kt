package com.example.testtaskansoft.feature.presentation.maps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.testtaskansoft.R
import com.example.testtaskansoft.core.base.BaseFragment
import com.example.testtaskansoft.databinding.FragmentMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.koin.androidx.viewmodel.ext.android.viewModel

class MapsFragment : BaseFragment<FragmentMapsBinding>() {

    override fun initBinding(inflater: LayoutInflater) = FragmentMapsBinding.inflate(inflater)

    private val viewModel by viewModel<MapsViewModel>()

    private val callback = OnMapReadyCallback { googleMap ->
        val baseLocation = LatLng(55.7522, 37.6156)
        googleMap.addMarker(MarkerOptions().position(baseLocation).title("Base Location"))
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(baseLocation, 10f))
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
        viewModel
    }
}