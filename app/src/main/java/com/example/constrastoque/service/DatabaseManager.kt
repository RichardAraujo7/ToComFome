package com.example.constrastoque.service

import androidx.room.Room

object DatabaseManager {
    private var dbInstance: ConstrastoqueDatabase
    init {
        val appContext = ConstrastoqueApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            appContext,
            ConstrastoqueDatabase::class.java,
            "constrastoque.sqlite"
        ).allowMainThreadQueries().build()
    }

    fun getEstoqueDAO(): EstoqueDAO {
        return dbInstance.estoqueDAO()
    }
}