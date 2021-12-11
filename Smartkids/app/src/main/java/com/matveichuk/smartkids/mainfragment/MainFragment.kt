package com.matveichuk.smartkids.mainfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.matveichuk.smartkids.R
import com.matveichuk.smartkids.databinding.FragmentMainBinding
import com.matveichuk.smartkids.mainfragment.adapter.MainAdapter
import com.matveichuk.smartkids.mainfragment.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null
    private val mainViewModel : MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainBinding.inflate(inflater, container, false)
        this.binding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.rcMain?.layoutManager = GridLayoutManager(context, 2)
        mainViewModel.mainLiveData.observe(viewLifecycleOwner, {
            binding?.rcMain?.adapter = MainAdapter(it) { delegate ->
                goToFragment(delegate.fragment)
            }
        })
    }

    private fun goToFragment(fragment: Fragment) {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.setCustomAnimations(R.anim.scale, R.anim.fade_out)
            ?.addToBackStack("n")
            ?.replace(R.id.recycleList, fragment)
            ?.commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }



}