package com.prography.android_6th_study.views

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.prography.android_6th_study.BaseFragment
import com.prography.android_6th_study.BaseViewModel
import com.prography.android_6th_study.databinding.FragmentContactBinding
import com.prography.android_6th_study.viewmodels.ContactViewModel

class ContactFragment : BaseFragment(), BaseViewModel.OnNavigateListener {

    private lateinit var binding: FragmentContactBinding
    private lateinit var vmContact: ContactViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContactBinding.inflate(inflater, container, false)
        vmContact = ViewModelProvider(this)[ContactViewModel::class.java]
        vmContact.mNavListener = this
        binding.viewmodel = vmContact

        return binding.root
    }

    override fun onNavigate() {
        var intent = Intent(binding.root.context, ChatActivity::class.java)
        startActivity(intent)
    }
}