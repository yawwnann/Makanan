package com.jo.catering.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.azhar.catering.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.azhar.catering.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mendapatkan instance dari SupportMapFragment dan mengatur callback OnMapReady
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Mengaktifkan kontrol UI tambahan pada peta
        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.uiSettings.isIndoorLevelPickerEnabled = true
        mMap.uiSettings.isCompassEnabled = true
        mMap.uiSettings.isMapToolbarEnabled = true

        // Menentukan lokasi Kota Yogyakarta
        val yogyakarta = LatLng(-7.797068, 110.370529) // Koordinat Yogyakarta
        val zoomLevel = 12f // Tingkat zoom peta

        // Menambahkan marker di Yogyakarta dan memindahkan kamera ke sana
        mMap.addMarker(MarkerOptions().position(yogyakarta).title("Kota Yogyakarta"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(yogyakarta, zoomLevel))
    }
}
