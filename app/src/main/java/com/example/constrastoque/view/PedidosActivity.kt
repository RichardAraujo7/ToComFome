package com.example.constrastoque.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.constrastoque.R
import kotlinx.android.synthetic.main.activity_pedidos.*

class PedidosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedidos)

        setSupportActionBar(toolbar_pedidos_activity as Toolbar?)
        supportActionBar?.title = "Pedidos"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}