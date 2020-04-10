package com.prography.android_6th_study.views

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavController.OnDestinationChangedListener
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.prography.android_6th_study.BaseActivity
import com.prography.android_6th_study.R
import com.prography.android_6th_study.databinding.ActivityMainBinding
import com.prography.android_6th_study.viewmodels.MainViewModel

class MainActivity : BaseActivity(),
    OnDestinationChangedListener,
    AppBarLayout.OnOffsetChangedListener {

    private lateinit var bind: ActivityMainBinding
    private lateinit var ncMain: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = DataBindingUtil.setContentView(this, R.layout.activity_main)
        bind.viewmodel = ViewModelProvider(this)[MainViewModel::class.java]

        /* Toolbar */
        (bind.tbMain.layoutParams as CollapsingToolbarLayout.LayoutParams).setMargins(
            0,
            getStatusBarHeight(),
            0,
            0
        )
        setSupportActionBar(bind.tbMain)
        supportActionBar!!.setDisplayHomeAsUpEnabled(false)

        /* AppBar Layout */
        bind.ablMain.addOnOffsetChangedListener(this)
        var appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.fg_home,
                R.id.fg_mytrip,
                R.id.fg_mypage,
                R.id.fg_promotion
            )
        )

        /* Nav Controller */
        ncMain = findNavController(R.id.nav_host_main);
        NavigationUI.setupWithNavController(bind.bnvMain, ncMain)
        bind.collMain.setupWithNavController(bind.tbMain, ncMain, appBarConfiguration)
        setupActionBarWithNavController(ncMain, appBarConfiguration)
        ncMain.addOnDestinationChangedListener(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp()
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        bind.collMain.background = when (destination.id) {
            R.id.fg_home -> getDrawable(R.drawable.background_collapse_boat)
            R.id.fg_promotion -> getDrawable(R.drawable.background_collapse_lighthouse)
            R.id.fg_mytrip -> getDrawable(R.drawable.background_collapse_boat)
            R.id.fg_mypage -> getDrawable(R.drawable.gradient_bcc6d2_dee5ed)
            else -> getDrawable(R.drawable.gradient_bcc6d2_dee5ed)
        }
        bind.ablMain.setExpanded(true, false)
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        val totalScroll = appBarLayout?.totalScrollRange;
        bind.tbMain.alpha = -verticalOffset / totalScroll!!.toFloat()
        bind.collMain.background.alpha =
            (((totalScroll + verticalOffset) / totalScroll.toFloat()) * 255).toInt()
    }
}
