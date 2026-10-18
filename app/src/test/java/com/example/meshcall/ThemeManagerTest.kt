package com.example.meshcall

import androidx.appcompat.app.AppCompatDelegate
import org.junit.Assert.assertEquals
import org.junit.Test

class ThemeManagerTest {

    @Test
    fun verifyThemeModeMappings() {
        assertEquals(
            AppCompatDelegate.MODE_NIGHT_NO,
            ThemeManager.getNightModeForTheme(ThemeManager.THEME_LIGHT)
        )
        assertEquals(
            AppCompatDelegate.MODE_NIGHT_YES,
            ThemeManager.getNightModeForTheme(ThemeManager.THEME_DARK)
        )
        // Fallback should default to Dark mode
        assertEquals(
            AppCompatDelegate.MODE_NIGHT_YES,
            ThemeManager.getNightModeForTheme("unknown_theme")
        )
    }

    @Test
    fun verifyThemeConstants() {
        assertEquals("light", ThemeManager.THEME_LIGHT)
        assertEquals("dark", ThemeManager.THEME_DARK)
        assertEquals("meshcall_theme_prefs", ThemeManager.PREFS_NAME)
        assertEquals("theme_mode", ThemeManager.KEY_THEME_MODE)
    }
}
