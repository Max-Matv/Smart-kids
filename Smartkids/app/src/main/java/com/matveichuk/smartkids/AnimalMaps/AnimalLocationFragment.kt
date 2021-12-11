package com.matveichuk.smartkids.AnimalMaps

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.matveichuk.smartkids.AnimalMaps.AnimalLocationVIewModel.AnimalLocationViewModel
import com.matveichuk.smartkids.AnimalMaps.adpter.AnimalLocationAdapter
import com.matveichuk.smartkids.R
import com.matveichuk.smartkids.databinding.FragmentAnimalLocationBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class AnimalLocationFragment : Fragment() {

    private var binding: FragmentAnimalLocationBinding? = null
    private val locationViewModel: AnimalLocationViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAnimalLocationBinding.inflate(inflater, container, false)
        this.binding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.rvMap?.layoutManager = GridLayoutManager(context, 2)
        locationViewModel.listData.observe(viewLifecycleOwner, {
            binding?.rvMap?.adapter = AnimalLocationAdapter(it) { delegate ->
                locationViewModel.idMap.value = delegate.polygon
                activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.recycleList, MapsFragment())
                    ?.addToBackStack("")
                    ?.commit()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}