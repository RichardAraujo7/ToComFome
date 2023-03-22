package com.example.tocomfome.service

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tocomfome.component.model.Estoque

@Database(entities = [Estoque::class], version = 1)
abstract class ToComFomeDatabase: RoomDatabase() {
    abstract fun estoqueDAO(): EstoqueDAO
}