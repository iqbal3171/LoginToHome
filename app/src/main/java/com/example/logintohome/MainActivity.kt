package com.example.logintohome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etUsername: EditText = findViewById(R.id.et_username)
        val btnLogin: Button = findViewById(R.id.btn_login)
        val btnRegister: Button = findViewById(R.id.btn_register) // <-- tombol daftar

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("EXTRA_USERNAME", username)
            startActivity(intent)
        }

        btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
