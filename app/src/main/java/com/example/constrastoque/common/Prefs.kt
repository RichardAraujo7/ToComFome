package com.example.constrastoque.common

import android.content.SharedPreferences
import com.example.constrastoque.service.ConstrastoqueApplication

object Prefs {
    val PREF_ID = "CONSTR"

    private fun prefs(): SharedPreferences {
        val context = ConstrastoqueApplication.getInstance().applicationContext
        return context.getSharedPreferences(PREF_ID, 0)
    }

    fun setBoolean(flag: String, valor: Boolean) =  prefs().edit().putBoolean(flag, valor).apply()

    fun getBoolean(flag: String) = prefs().getBoolean(flag, false)

    fun setString(flag: String, valor: String) =  prefs().edit().putString(flag, valor).apply()

    fun getString(flag: String) = prefs().getString(flag, "")

}
