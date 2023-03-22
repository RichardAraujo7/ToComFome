package com.example.tocomfome.component.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.GsonBuilder
import java.io.Serializable

@Entity(tableName = "estoque")
open class Estoque : Serializable {

    @PrimaryKey
    var id: Int = 0
    var imagem = ""
    var titulo = ""
    var quantidade: Int = 0
    var descricao = ""

    override fun toString(): String {
        return "item(nome='$titulo')"
    }

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}