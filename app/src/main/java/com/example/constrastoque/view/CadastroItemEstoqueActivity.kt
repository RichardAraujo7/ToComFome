package com.example.constrastoque.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.constrastoque.R
import com.example.constrastoque.component.model.Estoque
import com.example.constrastoque.service.EstoqueService
import kotlinx.android.synthetic.main.activity_cadastro_item_estoque.*

class CadastroItemEstoqueActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_item_estoque)
        setSupportActionBar(toolbar_cadastro_item_estoque_activity as Toolbar?)
        supportActionBar?.title = "Cadastro de item de estoque"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        salvarItem.setOnClickListener {
            val estoque = Estoque()

            if (etUrlImagem.text.toString() == "") Toast.makeText(this, "Insira o campo", Toast.LENGTH_LONG).show()
            else estoque.imagem = etUrlImagem.text.toString()

            if (etNomeItem.text.toString() == "") Toast.makeText(this, "Insira o campo", Toast.LENGTH_LONG).show()
            else estoque.titulo = etNomeItem.text.toString()

            if (etQuantidadeItem.text.toString() == "") Toast.makeText(this, "Insira o campo", Toast.LENGTH_LONG).show()
            else estoque.quantidade = etQuantidadeItem.text.toString().toInt()

            if (etDescricaoProduto.text.toString() == "") Toast.makeText(this, "Insira o campo", Toast.LENGTH_LONG).show()
            else estoque.descricao = etDescricaoProduto.text.toString()

            taskAtualizar(estoque)
        }
    }

    private fun taskAtualizar(estoque: Estoque) {
        Thread {
            EstoqueService.saveEstoque(estoque)
            runOnUiThread {
                finish()
            }
        }.start()
    }
}
