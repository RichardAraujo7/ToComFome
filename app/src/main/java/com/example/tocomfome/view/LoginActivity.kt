package com.example.tocomfome.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.example.tocomfome.R
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private lateinit var progressBarLogin: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        settingBehavior()
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            val intent = Intent(this, MainActivity::class.java)
            val params = Bundle()
            params.putString("nome", "Vendedor")
            intent.putExtras(params)
            startActivity(intent)
        }
    }

    private fun settingBehavior() {
        val editTextEmail: EditText = findViewById(R.id.eTTextPersonName)
        val editTextSenha: EditText = findViewById(R.id.eTTextPassword)
        val buttonEntrar: Button = findViewById(R.id.buttonEntrar)
        val buttonCadastrar: Button = findViewById(R.id.buttonCadastrar)
        val buttonSair: Button = findViewById(R.id.buttonSair)

        buttonSair.setOnClickListener {
            finish()
        }

        buttonCadastrar.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        buttonEntrar.setOnClickListener {
            val senha: String = editTextSenha.text.toString()
            val email: String = editTextEmail.text.toString()

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(this, "Insira o email", Toast.LENGTH_SHORT).show()
            }

            if (TextUtils.isEmpty(senha)) {
                Toast.makeText(this, "Insira a senha", Toast.LENGTH_SHORT).show()
            }

            auth.signInWithEmailAndPassword(email, senha)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(baseContext, "Login com sucesso.", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity::class.java)
                        val params = Bundle()
                        params.putString("nome", "Vendedor")
                        intent.putExtras(params)
                        startActivity(intent)
                    } else {
                        Toast.makeText(baseContext, "Login inválido.", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}