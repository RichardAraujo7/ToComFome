package com.example.constrastoque.service

import androidx.room.*
import com.example.constrastoque.component.model.Estoque

@Dao
interface EstoqueDAO {
    @Query("SELECT * FROM estoque where id =:id")
    fun getById(id: Int) : Estoque

    @Query("SELECT * FROM estoque")
    fun findAll(): List<Estoque>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(paises: Estoque)

    @Delete
    fun delete(paises: Estoque)

}