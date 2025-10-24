package com.example.logintohome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val rgGender = findViewById<RadioGroup>(R.id.rg_gender)
        val cbAgree = findViewById<CheckBox>(R.id.cb_agree)
        val spinnerCity = findViewById<Spinner>(R.id.spinner_city)
        val btnSubmit = findViewById<Button>(R.id.btn_submit_register)

        btnSubmit.setOnClickListener {
            // Ambil jenis kelamin
            val selectedId = rgGender.checkedRadioButtonId
            val genderText = if (selectedId != -1) {
                val radioButton = findViewById<RadioButton>(selectedId)
                radioButton.text.toString()
            } else {
                ""
            }

            val isAgree = cbAgree.isChecked
            val selectedCity = spinnerCity.selectedItem.toString()

            if (genderText.isEmpty()) {
                Toast.makeText(this, "Silakan pilih jenis kelamin.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!isAgree) {
                Toast.makeText(this, "Silakan setujui syarat & ketentuan.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val message = "Jenis Kelamin: $genderText, Domisili: $selectedCity, Setuju: $isAgree"
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }
    }
}
