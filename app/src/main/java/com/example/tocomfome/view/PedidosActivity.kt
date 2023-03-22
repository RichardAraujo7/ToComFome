package com.example.tocomfome.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.tocomfome.R
import com.example.tocomfome.component.view.EstoqueList
import kotlinx.android.synthetic.main.activity_pedidos.*

class PedidosActivity : AppCompatActivity() {
    private val context: Context get() = this
    private lateinit var pedidosList: EstoqueList
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedidos)

        setSupportActionBar(toolbar_pedidos_activity as Toolbar?)
        supportActionBar?.title = "Pedidos"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        init()
    }

    private fun init() {
        findIds()
        initialViews()
    }

    private fun initialViews() {
//        if (rvPedidosList?.isVisible == true) {
//            ivImageReports.visibility = View.GONE
//            tvInformativeRequestsText.visibility = View.GONE
//        }

        initInfoList()
    }

    private fun findIds() {
        pedidosList = findViewById(R.id.rvPedidosList)
    }

    private fun initInfoList() {
//        pedidosList.setStockList(
//            PedidosFactory.createList(
//                context
//            )
//        )
    }
}