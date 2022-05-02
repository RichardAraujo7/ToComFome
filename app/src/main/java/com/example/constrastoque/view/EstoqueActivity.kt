package com.example.constrastoque.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import com.example.constrastoque.R
import kotlinx.android.synthetic.main.activity_estoque.*

import kotlinx.android.synthetic.main.activity_main.toolbar_estoque_activity

class EstoqueActivity : AppCompatActivity() {
    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estoque)
        setSupportActionBar(toolbar_estoque_activity as Toolbar?)
        supportActionBar?.title = "Estoque"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        (menu?.findItem(R.id.action_buscar)?.actionView as SearchView?)?.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {

                override fun onQueryTextChange(newText: String): Boolean {
                    Toast.makeText(context, newText, Toast.LENGTH_SHORT).show()
                    return true
                }

                override fun onQueryTextSubmit(query: String): Boolean {
                    Toast.makeText(context, query, Toast.LENGTH_SHORT).show()
                    return false
                }

            })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_adicionar -> {
                val intentItemEstoque = Intent(this, CadastroItemEstoqueActivity::class.java)
                startActivity(intentItemEstoque)
            }
            R.id.action_atualizar -> {
                progressAtualizarEstoque.visibility = View.VISIBLE
                Handler(Looper.getMainLooper()).postDelayed(
                    {
                        progressAtualizarEstoque.visibility = View.GONE
                    },
                    10000
                )
            }

        }
        return super.onOptionsItemSelected(item)
    }
}