package com.example.carsharing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast



class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var colH: EditText
    private var money: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        colH = findViewById(R.id.editText)


        findViewById<RadioButton>(R.id.radioButton).setOnCheckedChangeListener { _ , isChecked ->
            if (isChecked)
                money = 10
        }
        findViewById<RadioButton>(R.id.radioButton2).setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
                money = 30
        }
        findViewById<RadioButton>(R.id.radioButton3).setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
                money = 100
        }




        button.setOnClickListener {
            val input = colH.text.toString()
            if (input.isEmpty() || input.isBlank()) {
                Toast.makeText(this, "Пожалуйста, введите число", Toast.LENGTH_SHORT).show()
            } else {
                val answer: Int = money * input.toInt()
                val price: Int = input.toInt()
                val intent = SecondActivity.newIntent(this@MainActivity, answer, price)
                intent.putExtra("price", price)
                startActivity(intent)
            }
        }

    }
}
