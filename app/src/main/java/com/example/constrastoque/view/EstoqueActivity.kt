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
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.constrastoque.R
import com.example.constrastoque.component.adapter.EstoqueRecyclerViewAdapter
import com.example.constrastoque.component.model.Estoque
import com.example.constrastoque.service.EstoqueService
import kotlinx.android.synthetic.main.activity_estoque.*

import kotlinx.android.synthetic.main.activity_main.toolbar_estoque_activity


class EstoqueActivity : AppCompatActivity() {
    var context: Context? = null
    lateinit var itens: List<Estoque>
    var estoque: Estoque? = null
    private lateinit var list: List<Estoque>
    private lateinit var adapter: EstoqueRecyclerViewAdapter
    private var ivImageReports: FrameLayout? = null
    private lateinit var estoqueAdapter: RecyclerView
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
        estoqueAdapter = findViewById(R.id.rvEstoqueAdapter)
    }

    private fun initialViews() {
        if (ivImageReports?.isVisible == true) {
            rvEstoqueAdapter.visibility = GONE
        }

        initInfoList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

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

    private fun setStockList(list: List<Estoque>) {
        this.list = list
        initAdapterValues()
    }

    private fun initAdapterValues() {
        val layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL, false
        )

        adapter = EstoqueRecyclerViewAdapter(itens) { index ->
            deleteItem(index)
        }

        rvEstoqueAdapter.adapter = adapter
        rvEstoqueAdapter.isNestedScrollingEnabled = false
        rvEstoqueAdapter.setHasFixedSize(true)
        rvEstoqueAdapter.layoutManager = layoutManager
    }

    private fun initInfoList() {
        Thread {
            itens = EstoqueService.getEstoque()
            runOnUiThread {
                setStockList(itens)
            }
        }.start()
    }

    private fun deleteItem(index: Int) {
        Thread {
            EstoqueService.delete(index)
            runOnUiThread {
                adapter.notifyItemRemoved(index)
                initInfoList()
            }
        }.start()
    }
}
