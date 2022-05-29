package com.example.tz1

import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import com.example.tz1.databinding.ActivityMainBinding
import com.example.tz1.themes.LightTheme
import com.example.tz1.themes.MyAppTheme
import com.example.tz1.utils.AppTheme
import com.example.tz1.utils.BaseActivity
import com.example.tz1.utils.ThemeManager

class MainActivity : BaseActivity() {
    private lateinit var binder: ActivityMainBinding
    private var number: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        number = intent.getIntExtra("number", 1)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
    }

    override fun syncTheme(appTheme: AppTheme) {
        val myAppTheme = appTheme as MyAppTheme
        binder.root.setBackgroundColor(myAppTheme.activityIconColor(this))
        syncStatusBarIconColors(appTheme)
    }

    override fun getStartTheme(): AppTheme {
        return LightTheme()
    }

    private fun syncStatusBarIconColors(theme: MyAppTheme) {
        ThemeManager.instance.syncStatusBarIconsColorWithBackground(
            this,
            theme.activityThemeButtonColor(this)
        )
        ThemeManager.instance.syncNavigationBarButtonsColorWithBackground(
            this,
            theme.activityImageRes(this)
        )
    }
}