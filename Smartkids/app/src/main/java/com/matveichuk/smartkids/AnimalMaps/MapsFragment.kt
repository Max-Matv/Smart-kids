package com.matveichuk.smartkids.AnimalMaps

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.matveichuk.smartkids.AnimalMaps.AnimalLocationVIewModel.AnimalLocationViewModel
import com.matveichuk.smartkids.R
import com.matveichuk.smartkids.databinding.FragmentMapsBinding

class MapsFragment : Fragment() {

    private val locationViewModel: AnimalLocationViewModel by activityViewModels()
    private var binding: FragmentMapsBinding? = null


    private val callback = OnMapReadyCallback { googleMap ->
        locationViewModel.idMap.observe(activity as LifecycleOwner, {
            googleMap.addPolygon(
                it
            )

        })

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMapsBinding.inflate(inflater, container, false)
        this.binding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}