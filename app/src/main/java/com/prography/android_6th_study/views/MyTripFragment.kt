package com.prography.android_6th_study.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.prography.android_6th_study.BaseFragment
import com.prography.android_6th_study.databinding.FragmentMytripBinding
import com.prography.android_6th_study.viewmodels.MyTripViewModel

class MyTripFragment : BaseFragment() {

    private lateinit var binding: FragmentMytripBinding
    private lateinit var vmMyTrip: MyTripViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMytripBinding.inflate(inflater, container, false)
        vmMyTrip = ViewModelProvider(this)[MyTripViewModel::class.java]
        binding.lifecycleOwner = this
        binding.viewmodel = vmMyTrip

        /* RecyclerView Adapter */
        binding.rvThemeMytrip.adapter = vmMyTrip.tAdapter
        binding.rvPopularsMytrip.adapter = vmMyTrip.pAdapter
        vmMyTrip.popularsMyTripList.observe(
            viewLifecycleOwner,
            Observer { list -> vmMyTrip.pAdapter.submitList(list) })

        return binding.root
    }


}