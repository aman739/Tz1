package com.example.tz1.utils

import androidx.fragment.app.Fragment

abstract class ThemeFragment : Fragment() {

    override fun onResume() {
        getThemeManager()?.getCurrentLiveTheme()?.observe(this) {
            syncTheme(it)
        }

        super.onResume()
    }

    protected fun getThemeManager() : ThemeManager? {
        return ThemeManager.instance
    }

    abstract fun syncTheme(appTheme: AppTheme)
}