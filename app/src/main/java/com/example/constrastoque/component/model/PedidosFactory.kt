package com.example.constrastoque.component.model

import android.content.Context
import com.example.constrastoque.R

object PedidosFactory {
    fun createList(context: Context): MutableList<EstoqueModel> {
        val list: MutableList<EstoqueModel> = mutableListOf()
        list.add(EstoqueModel(R.drawable.tenis_icon_1, context.getString(R.string.texto_tenis_nome_1), context.getString(
                R.string.texto_tenis_desc), 30))
        list.add(EstoqueModel(R.drawable.tenis_icon_2, context.getString(R.string.texto_tenis_nome_2), context.getString(
                R.string.texto_tenis_desc), 25))
        list.add(EstoqueModel(R.drawable.tenis_icon_3, context.getString(R.string.texto_tenis_nome_3), context.getString(R.string.texto_tenis_desc), 20))
        list.add(EstoqueModel(R.drawable.tenis_icon_4, context.getString(R.string.texto_tenis_nome_4), context.getString(R.string.texto_tenis_desc), 15))
        return list
    }
}