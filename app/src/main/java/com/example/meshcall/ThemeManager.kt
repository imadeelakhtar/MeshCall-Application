package com.example.meshcall

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatDelegate

object ThemeManager {
    const val PREFS_NAME = "meshcall_theme_prefs"
    const val KEY_THEME_MODE = "theme_mode"

    const val THEME_LIGHT = "light"
    const val THEME_DARK = "dark"

    fun getNightModeForTheme(themeMode: String): Int {
        return when (themeMode) {
            THEME_LIGHT -> AppCompatDelegate.MODE_NIGHT_NO
            THEME_DARK -> AppCompatDelegate.MODE_NIGHT_YES
            else -> AppCompatDelegate.MODE_NIGHT_YES
        }
    }

    private fun getPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun getSavedTheme(context: Context): String {
        val prefs = getPrefs(context)
        if (prefs.contains(KEY_THEME_MODE)) {
            return prefs.getString(KEY_THEME_MODE, THEME_DARK) ?: THEME_DARK
        }
        val isSystemNight = (context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES
        return if (isSystemNight) THEME_DARK else THEME_LIGHT
    }

    fun isDarkTheme(context: Context): Boolean {
        return getSavedTheme(context) == THEME_DARK
    }

    fun applyTheme(themeMode: String, context: Context) {
        getPrefs(context).edit().putString(KEY_THEME_MODE, themeMode).apply()
        val targetMode = getNightModeForTheme(themeMode)
        if (AppCompatDelegate.getDefaultNightMode() != targetMode) {
            AppCompatDelegate.setDefaultNightMode(targetMode)
        }
    }

    fun initTheme(context: Context) {
        val themeMode = getSavedTheme(context)
        val targetMode = getNightModeForTheme(themeMode)
        if (AppCompatDelegate.getDefaultNightMode() != targetMode) {
            AppCompatDelegate.setDefaultNightMode(targetMode)
        }
    }
}
