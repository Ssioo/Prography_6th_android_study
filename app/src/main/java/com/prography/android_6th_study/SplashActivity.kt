package com.prography.android_6th_study

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.prography.android_6th_study.databinding.ActivitySplashBinding
import com.prography.android_6th_study.views.MainActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var bind: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        Handler().postDelayed(
            {
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }, 1000
        )
    }
}
