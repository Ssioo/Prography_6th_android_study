package com.prography.android_6th_study.views

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.prography.android_6th_study.BaseFragment
import com.prography.android_6th_study.R
import com.prography.android_6th_study.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment() {

    private lateinit var mContext: Context
    private lateinit var bind: FragmentHomeBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return bind.root
    }
}