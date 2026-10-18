package com.example.meshcall

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class SettingsActivity : AppCompatActivity() {
    private lateinit var profileManager: ProfileManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val toolbar = findViewById<Toolbar>(R.id.toolbarSettings)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }

        profileManager = ProfileManager(this)
        
        val buttonEditProfile = findViewById<Button>(R.id.buttonEditProfile)
        val launchEditProfile = View.OnClickListener {
            startActivity(Intent(this, EditProfileActivity::class.java))
        }
        buttonEditProfile.setOnClickListener(launchEditProfile)
        findViewById<ImageView>(R.id.imageSettingsAvatar).setOnClickListener(launchEditProfile)
        findViewById<ImageView>(R.id.imageSettingsEditPencil).setOnClickListener(launchEditProfile)

        initThemeSelector()
    }
    
    private fun initThemeSelector() {
        val layoutOptionLight = findViewById<LinearLayout>(R.id.layoutOptionLight)
        val layoutOptionDark = findViewById<LinearLayout>(R.id.layoutOptionDark)
        val radioThemeLight = findViewById<RadioButton>(R.id.radioThemeLight)
        val radioThemeDark = findViewById<RadioButton>(R.id.radioThemeDark)
        val badgeThemeLightActive = findViewById<TextView>(R.id.badgeThemeLightActive)
        val badgeThemeDarkActive = findViewById<TextView>(R.id.badgeThemeDarkActive)

        val isDark = ThemeManager.isDarkTheme(this)
        radioThemeDark.isChecked = isDark
        radioThemeLight.isChecked = !isDark
        badgeThemeDarkActive.visibility = if (isDark) View.VISIBLE else View.GONE
        badgeThemeLightActive.visibility = if (isDark) View.GONE else View.VISIBLE

        val selectLight = View.OnClickListener {
            if (ThemeManager.isDarkTheme(this)) {
                ThemeManager.applyTheme(ThemeManager.THEME_LIGHT, this)
            }
        }

        val selectDark = View.OnClickListener {
            if (!ThemeManager.isDarkTheme(this)) {
                ThemeManager.applyTheme(ThemeManager.THEME_DARK, this)
            }
        }

        layoutOptionLight.setOnClickListener(selectLight)
        radioThemeLight.setOnClickListener(selectLight)

        layoutOptionDark.setOnClickListener(selectDark)
        radioThemeDark.setOnClickListener(selectDark)
    }

    override fun onResume() {
        super.onResume()
        val profile = profileManager.getProfile()
        if (profile != null) {
            findViewById<TextView>(R.id.textSettingsDisplayName).text = profile.displayName
            findViewById<TextView>(R.id.textSettingsUsername).text = "@${profile.username}"
            findViewById<ImageView>(R.id.imageSettingsAvatar).loadAvatar(profile.avatarUri)
        }
    }
}
