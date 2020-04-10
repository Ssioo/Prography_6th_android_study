package com.prography.android_6th_study

import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel(), Observable {

    lateinit var mNavListener: OnNavigateListener
    var registry: PropertyChangeRegistry = PropertyChangeRegistry()

    interface OnNavigateListener {
        fun onNavigate()
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        registry.remove(callback)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        registry.add(callback)
    }
}