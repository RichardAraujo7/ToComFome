package com.example.constrastoque.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.constrastoque.R
import com.example.constrastoque.component.model.Estoque
import com.example.constrastoque.service.EstoqueService
import kotlinx.android.synthetic.main.activity_cadastro_item_estoque.*

class EditItemEstoqueActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_item_estoque)
        setSupportActionBar(toolbar_cadastro_item_estoque_activity as Toolbar?)
        supportActionBar?.title = "Editar item de estoque"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val args = intent.extras
        val index = args?.getInt("index")


        salvarItem.setOnClickListener {
            val estoque = Estoque()
            estoque.id = index!!
            if (etUrlImagem.text.toString() == "") Toast.makeText(this, "Insira o campo", Toast.LENGTH_LONG).show()
            else estoque.imagem = etUrlImagem.text.toString()

            if (etNomeItem.text.toString() == "") Toast.makeText(this, "Insira o campo", Toast.LENGTH_LONG).show()
            else estoque.titulo = etNomeItem.text.toString()

            if (etQuantidadeItem.text.toString() == "") Toast.makeText(this, "Insira o campo", Toast.LENGTH_LONG).show()
            else estoque.quantidade = etQuantidadeItem.text.toString().toInt()

            if (etDescricaoProduto.text.toString() == "") Toast.makeText(this, "Insira o campo", Toast.LENGTH_LONG).show()
            else estoque.descricao = etDescricaoProduto.text.toString()

            Thread {
                index.let { it1 -> EstoqueService.update(estoque, it1) }
                runOnUiThread {
                    finish()
                }
            }.start()
        }
    }
}
