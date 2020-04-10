package com.prography.android_6th_study.views

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.prography.android_6th_study.BaseFragment
import com.prography.android_6th_study.R
import com.prography.android_6th_study.databinding.FragmentMypageBinding
import com.prography.android_6th_study.viewmodels.MyPageViewModel

class MyPageFragment : BaseFragment(), MyPageViewModel.NavigationListener {

    private lateinit var mContext: Context
    private lateinit var binding: FragmentMypageBinding
    private lateinit var vmMyPage: MyPageViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMypageBinding.inflate(inflater, container, false)
        vmMyPage = ViewModelProvider(this)[MyPageViewModel::class.java]
        vmMyPage.mNavListener = this
        binding.viewmodel = vmMyPage

        /* ActionBar */
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onNavigate() {
        Navigation.findNavController(binding.root).navigate(R.id.action_to_contact)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_settings, menu)
    }
}