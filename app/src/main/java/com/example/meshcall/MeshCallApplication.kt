package com.example.meshcall

import android.app.Application

class MeshCallApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ThemeManager.initTheme(this)
    }
}
