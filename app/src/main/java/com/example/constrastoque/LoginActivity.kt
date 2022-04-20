package com.example.constrastoque

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        buttonEntrar.setOnClickListener {
             onClickLogin()
        }

        buttonSair.setOnClickListener {
            finish()
        }
    }

    private fun onClickLogin(){
        val valorUsuario = eTTextPersonName.text.toString()
        val valorSenha = eTTextPassword.text.toString()

        val intent = Intent(this, MainActivity::class.java)
        val params = Bundle()
        params.putString("nome", valorUsuario)
        intent.putExtras(params)

        if (valorUsuario != "aluno" || valorSenha != "impacta")  {
            Toast.makeText(this, "Insira usuário ou senha corretamente", Toast.LENGTH_LONG).show()
        } else {
            startActivity(intent)
        }

    }
}