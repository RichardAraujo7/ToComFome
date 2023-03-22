package com.example.tocomfome.service

import com.example.tocomfome.component.model.Estoque
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URL

object EstoqueService {
    const val host = "http://192.168.0.10:5002"
    const val TAG = "ToComFomeAPI"

    fun getEstoque(): List<Estoque> {
        var estoque = ArrayList<Estoque>()
        if (AndroidUtils.isInternetDisponivel()) {
            val url = "$host/estoque"
            val json = URL(url).readText()
            estoque = parserJson(json)
            for (items in estoque) {
                saveOffline(items)
            }
            return estoque
        } else  {
            val dao = DatabaseManager.getEstoqueDAO()
            dao.findAll()
            return estoque
        }
    }

    fun saveEstoque(estoque: Estoque): Response {
        return try {
            val json = HttpHelper.post("$host/estoque/adicionarItemEstoque", estoque.toJson())
            parserJson(json)
        } catch (ex: Exception) {
            DatabaseManager.getEstoqueDAO().insert(estoque)
            Response("ok", "ok")
        }
    }

    fun update(estoque: Estoque, index: Int): Response {
        return try  {
            val json = HttpHelper.put("$host/estoque/$index", estoque.toJson())
            parserJson(json)
        } catch (ex: Exception) {
            DatabaseManager.getEstoqueDAO().insert(estoque)
            Response("ok", "ok")
        }
    }

    fun saveOffline(paises: Estoque): Boolean {
        val dao = DatabaseManager.getEstoqueDAO()
        if (!existeEstoque(paises)) {
            dao.insert(paises)
        }
        return true
    }

    fun existeEstoque(estoque: Estoque): Boolean {
        val dao = DatabaseManager.getEstoqueDAO()
        return dao.getById(estoque.id) != null
    }


    fun delete(index: Int): Response {
        try {
            val url = "$host/estoque/$index"
            val json = HttpHelper.delete(url)
            return parserJson(json)
        } catch (ex: Exception) {
            val dao = DatabaseManager.getEstoqueDAO()
            dao.delete(dao.getById(index))
            return Response(status = "OK", msg = "Dados salvos localmente")
        }
    }

    private inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>() {}.type
        return Gson().fromJson<T>(json, type)
    }
}