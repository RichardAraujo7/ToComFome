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
import android.view.View.GONE
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import com.example.constrastoque.R
import com.example.constrastoque.component.adapter.EstoqueRecyclerViewAdapter
import com.example.constrastoque.component.model.Estoque
import com.example.constrastoque.component.view.EstoqueList
import com.example.constrastoque.service.EstoqueService
import kotlinx.android.synthetic.main.activity_estoque.*

import kotlinx.android.synthetic.main.activity_main.toolbar_estoque_activity
import kotlinx.android.synthetic.main.item_estoque_recycler_view_list.*

class EstoqueActivity : AppCompatActivity() {
    private val context: Context get() = this
    private var itens = listOf<Estoque>()
    private var ivImageReports: FrameLayout? = null
    private lateinit var estoqueLimit: EstoqueList
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estoque)
        setSupportActionBar(toolbar_estoque_activity as Toolbar?)
        supportActionBar?.title = "Estoque"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        init()
    }

    private fun init() {
        findIds()
        initialViews()
    }

    private fun findIds() {
        ivImageReports = findViewById(R.id.ivImageReports)
        estoqueLimit = findViewById(R.id.rvEstoqueList)
    }

    private fun initialViews() {
        if (ivImageReports?.isVisible == true) {
            rvEstoqueList.visibility = GONE
        }

        initInfoList()
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

    private fun initInfoList() {
        Thread {
            itens = EstoqueService.getEstoque()
            runOnUiThread {
                estoqueLimit.setStockList(itens)

            }
        }.start()
    }
}