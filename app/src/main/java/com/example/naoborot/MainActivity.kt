package com.example.naoborot

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var titleTV : TextView
    private lateinit var editTextET : EditText
    private lateinit var buttonBTN : Button
    private lateinit var resultTV : TextView
    private lateinit var counterTV : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        titleTV = findViewById(R.id.titleTV)
        editTextET = findViewById(R.id.edit_text_ET)
        buttonBTN = findViewById(R.id.button)
        resultTV = findViewById(R.id.result)
        counterTV = findViewById(R.id.counter)

        onClickButton(buttonBTN)
    }

    fun onClickButton(view: View){
        val line = editTextET.text.trim()
        resultTV.text = line.reversed()
        counterTV.text = line.filter { it != ' ' }.length.toString()
    }
}