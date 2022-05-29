package com.example.tz1.themes

import android.content.Context
import androidx.core.content.ContextCompat
import com.example.tz1.themes.MyAppTheme
import com.example.tz1.R

class LightTheme : MyAppTheme {

    companion object {
        val ThemeId = 0
    }

    override fun id(): Int {
        return ThemeId
    }

    override fun activityBackgroundColor(context: Context): Int {
        return ContextCompat.getColor(context, R.color.white)
    }

    override fun activityImageRes(context: Context): Int {
        return R.color.white
    }

    override fun activityIconColor(context: Context): Int {
        return ContextCompat.getColor(context, R.color.black)
    }

    override fun activityTextColor(context: Context): Int {
        return ContextCompat.getColor(context, R.color.black)
    }

    override fun activityThemeButtonColor(context: Context): Int {
        return ContextCompat.getColor(context, R.color.white)
    }
}