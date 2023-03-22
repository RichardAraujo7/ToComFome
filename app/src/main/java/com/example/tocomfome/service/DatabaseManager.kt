package com.example.tocomfome.service

import androidx.room.Room

object DatabaseManager {
    private var dbInstance: ToComFomeDatabase
    init {
        val appContext = ToComFomeApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            appContext,
            ToComFomeDatabase::class.java,
            "tocomfome.sqlite"
        ).allowMainThreadQueries().build()
    }

    fun getEstoqueDAO(): EstoqueDAO {
        return dbInstance.estoqueDAO()
    }
}