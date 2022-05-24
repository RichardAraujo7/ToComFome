package com.example.constrastoque.service

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.constrastoque.component.model.Estoque

@Database(entities = [Estoque::class], version = 1)
abstract class ConstrastoqueDatabase: RoomDatabase() {
    abstract fun estoqueDAO(): EstoqueDAO
}