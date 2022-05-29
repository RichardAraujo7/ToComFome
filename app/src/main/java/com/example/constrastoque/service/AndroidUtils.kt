package com.example.constrastoque.service

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

object AndroidUtils {
    fun isInternetDisponivel(): Boolean {
        val conexao =
            ConstrastoqueApplication.getInstance().applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities = conexao.getNetworkCapabilities(conexao.activeNetwork)
        if (capabilities != null) {
            when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                    return true
                }
            }
        }
        return false
    }
}