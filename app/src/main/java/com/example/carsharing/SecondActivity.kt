package com.example.carsharing

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.content.Intent
import android.widget.EditText
import android.widget.TextView

private const val EXTRA = "com.example.carsharing.answer"
private const val PRICE = "com.example.carsharing.price"

class SecondActivity : AppCompatActivity() {
    private var answer = 0
    private var price = 0
    private lateinit var fullAnswer: TextView
    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        fullAnswer = findViewById(R.id.textView)
        answer = intent.getIntExtra(EXTRA, 0)
        price = intent.getIntExtra(PRICE, 0)

        fullAnswer.setText("Сумма заказа = $answer рублей, $price страниц")
    }

    companion object {
        fun newIntent(packageContext: Context, answer: Int, price: Int): Intent {
            return Intent(packageContext, SecondActivity::class.java).apply {
                putExtra(EXTRA, answer)
                putExtra(PRICE, price)
            }
        }
    }

}
