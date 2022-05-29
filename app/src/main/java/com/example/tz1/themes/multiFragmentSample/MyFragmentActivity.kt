package com.example.tz1.themes.multiFragmentSample

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.WindowManager
import com.example.tz1.R
import com.example.tz1.databinding.ActivityMainBinding
import com.example.tz1.themes.LightTheme
import com.example.tz1.utils.AppTheme
import com.example.tz1.utils.BaseActivity

class MyFragmentActivity : BaseActivity() {

    private var fragmentNumber: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // full screen app
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }

        val binder = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binder.root)
    }

    override fun syncTheme(appTheme: AppTheme) {
    }

    override fun getStartTheme(): AppTheme {
        return LightTheme()
    }
}