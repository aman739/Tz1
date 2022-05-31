package com.example.tz1.reverseSample

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.WindowManager
import com.example.tz1.R
import com.example.tz1.databinding.ReverseActivityBinding
import com.example.tz1.themes.LightTheme
import com.example.tz1.themes.MyAppTheme
import com.example.tz1.themes.NightTheme
import com.example.tz1.utils.AppTheme
import com.example.tz1.utils.BaseActivity
import com.example.tz1.utils.ThemeManager


class ReverseActivity : BaseActivity() {

    private lateinit var binder: ReverseActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // full screen app
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }

        // create and bind views
        binder = ReverseActivityBinding.inflate(LayoutInflater.from(this))
        setContentView(binder.root)

        // set change theme click listeners for buttons
        updateButtonText()
        binder.dayToggleButton.setOnClickListener {

            if (ThemeManager.instance.getCurrentTheme()
                    ?.id() == NightTheme.ThemeId
            ) {
                ThemeManager.instance.reverseChangeTheme(LightTheme(), it)
            } else if (ThemeManager.instance.getCurrentTheme()
                    ?.id() != NightTheme.ThemeId
            ) {
                ThemeManager.instance.changeTheme(NightTheme(), it)
            }
            updateButtonText()
        }
    }

    // to sync ui with selected theme
    override fun syncTheme(appTheme: AppTheme) {
        // change ui colors with new appThem here
        val myAppTheme = appTheme as MyAppTheme

        // set background color
        binder.root.setBackgroundColor(myAppTheme.activityBackgroundColor(this))

        //syncStatusBarIconColors
        syncStatusBarIconColors(appTheme)
    }

    fun updateButtonText() {
        if (ThemeManager.instance.getCurrentTheme()?.id() == NightTheme.ThemeId) {
            binder.dayToggleButton.setImageResource(R.drawable.day)
            binder.dayToggleButton.setBackgroundColor(Color.parseColor("#FF000000"))
        } else {
            binder.dayToggleButton.setImageResource(R.drawable.night)
            binder.dayToggleButton.setBackgroundColor(Color.parseColor("#FFBB86FC"))
        }
    }

    // to get stat theme
    override fun getStartTheme(): AppTheme {
        return LightTheme()
    }

    private fun syncStatusBarIconColors(theme: MyAppTheme) {
        ThemeManager.instance.syncStatusBarIconsColorWithBackground(
            this,
            theme.activityBackgroundColor(this)
        )
        ThemeManager.instance.syncNavigationBarButtonsColorWithBackground(
            this,
            theme.activityBackgroundColor(this)
        )
    }
}