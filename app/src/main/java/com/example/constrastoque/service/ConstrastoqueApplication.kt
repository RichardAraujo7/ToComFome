package com.example.constrastoque.service

import android.app.Application
import java.lang.IllegalStateException

class ConstrastoqueApplication: Application() {
override fun onCreate() {
    super.onCreate()
    appInstance = this
}

    companion object {
        private var appInstance: ConstrastoqueApplication?  = null
        fun getInstance(): ConstrastoqueApplication {
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