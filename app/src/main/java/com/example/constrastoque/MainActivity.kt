package com.example.constrastoque

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.toolbar_estoque_activity

class MainActivity : AppCompatActivity() {
    private val context: Context get() = this
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar_estoque_activity as Toolbar?)
        supportActionBar?.title = "Relatórios"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val args = intent.extras
        val usuario = args?.getString("nome")
        val intentEstoque = Intent(this, EstoqueActivity::class.java)
        val intentPedidos = Intent(this, PedidosActivity::class.java)
        textoTelaInicial.text = "Bem vindo $usuario"
        botaoSair.setOnClickListener { finish() }
        if (usuario == null) {
            textoTelaInicial.visibility = View.GONE
        }
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.abrir, R.string.fechar)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_drawer_estoque -> startActivity(intentEstoque)
                R.id.nav_drawer_pedidos -> startActivity(intentPedidos)
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        when (id) {
            R.id.action_config -> {
                Toast.makeText(this, "Botão de configuracoes", Toast.LENGTH_LONG).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_configurar, menu)
        return true
    }

}

