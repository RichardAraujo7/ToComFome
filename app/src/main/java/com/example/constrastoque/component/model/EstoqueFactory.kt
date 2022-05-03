package com.example.constrastoque.component.model

import android.content.Context
import com.example.constrastoque.R

object EstoqueFactory {
    fun createList(context: Context): MutableList<EstoqueModel> {
        val list: MutableList<EstoqueModel> = mutableListOf()
        list.add(EstoqueModel(R.drawable.relogio_icon_1, context.getString(R.string.texto_relogio_nome_1), context.getString(R.string.texto_relogio_desc), 30))
        list.add(EstoqueModel(R.drawable.relogio_icon_2, context.getString(R.string.texto_relogio_nome_2), context.getString(R.string.texto_relogio_desc), 25))
        list.add(EstoqueModel(R.drawable.relogio_icon_3, context.getString(R.string.texto_relogio_nome_3), context.getString(R.string.texto_relogio_desc), 20))
        list.add(EstoqueModel(R.drawable.relogio_icon_4, context.getString(R.string.texto_relogio_nome_4), context.getString(R.string.texto_relogio_desc), 15))
        return list
    }
}