package com.example.constrastoque.service

import android.app.Application
import java.lang.IllegalStateException

class ConstrastoqueApplication: Application() {// chamado quando android iniciar o processo da aplicação
override fun onCreate() {
    super.onCreate()
    appInstance = this
}

    companion object {
        // singleton
        private var appInstance: ConstrastoqueApplication?  = null
        fun getInstance(): ConstrastoqueApplication {
            if (appInstance == null) {
                throw IllegalStateException("Configurar application no Android Manifest")
            }
            return appInstance!!
        }
    }

    // chamado quando android terminar processo da aplicação
    override fun onTerminate() {
        super.onTerminate()
    }
}