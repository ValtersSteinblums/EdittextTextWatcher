package com.example.edittexttextwatcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var editTextName: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.edit_text_name)
        editTextPassword = findViewById(R.id.edit_text_password)
        loginButton = findViewById(R.id.login_button)

        editTextName.addTextChangedListener(textWatcher)
        editTextPassword.addTextChangedListener(textWatcher)
    }

    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            loginButton.isEnabled = editTextName.text.toString().trim().isNotEmpty()
                    && editTextPassword.text.toString().trim().isNotEmpty()
        }

        override fun afterTextChanged(s: Editable?) {

        }

    }
}