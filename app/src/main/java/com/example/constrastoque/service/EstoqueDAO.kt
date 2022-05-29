package com.example.constrastoque.service

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.constrastoque.component.model.Estoque

@Dao
interface EstoqueDAO {
    @Query("SELECT * FROM estoque where id =:id")
    fun getById(id: Int) : Estoque

    @Query("SELECT * FROM estoque")
    fun findAll(): List<Estoque>

    @Insert
    fun insert(paises: Estoque)

    @Delete
    fun delete(paises: Estoque)

}