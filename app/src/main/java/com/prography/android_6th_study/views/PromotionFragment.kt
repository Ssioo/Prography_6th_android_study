package com.prography.android_6th_study.views

import android.content.Context
import android.os.Bundle
import android.view.*
import com.prography.android_6th_study.BaseFragment
import com.prography.android_6th_study.R

class PromotionFragment : BaseFragment() {

    private lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_promotion, container, false)
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_default, menu)
    }
}