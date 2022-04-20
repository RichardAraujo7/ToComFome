package com.example.constrastoque

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_cadastro_item_estoque.*

class CadastroItemEstoque : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_item_estoque)
        setSupportActionBar(toolbar_cadastro_item_estoque_activity as Toolbar?)
        supportActionBar?.title = "Cadastro de item de estoque"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}