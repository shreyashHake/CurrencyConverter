package com.example.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val convert = findViewById<Button>(R.id.convert)
        convert.setOnClickListener {
            convertTo()
        }
        val clear : Button = findViewById(R.id.clear_text)
        clear.setOnClickListener {
            resetValue()
        }
    }

    private fun resetValue() {
        val usdInput = findViewById<EditText>(R.id.usdInput)
        val inrInput = findViewById<EditText>(R.id.inrInput)
        usdInput.setText("")
        inrInput.setText("")
    }

    private fun convertTo() {
        val usdInput = findViewById<EditText>(R.id.usdInput)
        val usd = usdInput.text.toString().toDoubleOrNull()

        val inrInput = findViewById<EditText>(R.id.inrInput)
        val inr = inrInput.text.toString().toDoubleOrNull()

        if (usd == null && inr == null) {
            usdInput.setText("")
            inrInput.setText("")
            return;
        } else if (inr == null) {
            val answer = usd?.div(76.10)
            inrInput.setText(answer.toString())
        } else if (usd == null){
            val answer = inr * 76.10
            usdInput.setText(answer.toString())
        }
    }
}