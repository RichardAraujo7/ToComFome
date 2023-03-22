package com.example.tocomfome.service

import android.app.Application
import java.lang.IllegalStateException

class ToComFomeApplication: Application() {
override fun onCreate() {
    super.onCreate()
    appInstance = this
}

    companion object {
        private var appInstance: ToComFomeApplication?  = null
        fun getInstance(): ToComFomeApplication {
            if (appInstance == null) {
                throw IllegalStateException("Configurar application no Android Manifest")
            }
            return appInstance!!
        }
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}