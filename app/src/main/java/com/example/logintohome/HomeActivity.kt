package com.example.logintohome

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(R.id.fragment_container, DashboardFragment())
            }
        }

        val tvWelcomeMessage: TextView? = findViewById(R.id.tv_welcome_message)
        val username = intent.getStringExtra("EXTRA_USERNAME")
        tvWelcomeMessage?.text = "Selamat Datang, $username!"

        val btnOpenWebsite: Button? = findViewById(R.id.btn_open_website)
        btnOpenWebsite?.setOnClickListener {
            val url = "https://amikom.ac.id"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "Tidak ada aplikasi browser yang tersedia", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
