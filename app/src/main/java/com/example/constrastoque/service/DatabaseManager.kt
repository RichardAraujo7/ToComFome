package com.example.constrastoque.service

import androidx.room.Room

object DatabaseManager {
    private var dbInstance: ConstrastoqueDatabase
    init {
        val appContext = ConstrastoqueApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            appContext, // contexto global
            ConstrastoqueDatabase::class.java, // Referência da classe do banco
            "lmsss.sqlite" // nome do arquivo do banco
        ).build()
    }

    fun getEstoqueDAO(): EstoqueDAO {
        return dbInstance.estoqueDAO()
    }
}