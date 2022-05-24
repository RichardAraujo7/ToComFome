package com.example.constrastoque.service

import android.util.Log
import com.example.constrastoque.component.model.Estoque
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URL

object EstoqueService {
    val host = "http://192.168.0.13:5002"
    val TAG = "ConstrastoqueAPI"

    fun getEstoque (): List<Estoque> {
        return try {
            val url = "$host/estoque"
            val json = URL(url).readText()
            Log.d(TAG, json)
            parserJson<List<Estoque>>(json)
        } catch (ex: Exception) {
            DatabaseManager.getEstoqueDAO().findAll()
        }
    }

    fun saveEstoque(estoque: Estoque): Response {
        try {
            val json = HttpHelper.post("$host/estoque", estoque.toJson())
            return parserJson(json)
        } catch (ex: Exception) {
            DatabaseManager.getEstoqueDAO().insert(estoque)
            return Response("ok", "ok")
        }
    }

    private inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}