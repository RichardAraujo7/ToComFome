package com.example.tocomfome.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.example.tocomfome.R
import com.example.tocomfome.service.EstoqueService.TAG
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        startActions()
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if(currentUser != null){
            val intent = Intent(this, MainActivity::class.java)
            val params = Bundle()
            params.putString("nome", "Vendedor")
            intent.putExtras(params)
            startActivity(intent)
        }
    }

    private fun startActions() {
        val editTextEmail: EditText = findViewById(R.id.eTTextPersonNameRegister)
        val editTextSenha: EditText = findViewById(R.id.eTTextPasswordRegister)
        val buttonRegister: Button = findViewById(R.id.buttonRegistrar)
        val progressBar: ProgressBar = findViewById(R.id.progressAtualizaCadastro)
        val buttonGoToLogin: Button = findViewById(R.id.buttonVoltarLogin)

        buttonRegister.setOnClickListener {
            val senha: String = editTextSenha.text.toString()
            val email: String = editTextEmail.text.toString()

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(this, "Insira o email", Toast.LENGTH_SHORT).show()
            }

            if (TextUtils.isEmpty(senha)) {
                Toast.makeText(this, "Insira a senha", Toast.LENGTH_SHORT).show()
            }

            progressBar.visibility = View.VISIBLE

            auth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener(this) { task ->
                    progressBar.visibility = View.GONE
                    if (task.isSuccessful) {
                        Toast.makeText(baseContext, "Cadastro realizado.",
                            Toast.LENGTH_SHORT).show()
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Erro desconhecido.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        }

        buttonGoToLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}