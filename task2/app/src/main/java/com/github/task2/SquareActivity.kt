package com.github.task2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SquareActivity : AppCompatActivity() {

    private val tag = this.javaClass.simpleName
    private lateinit var squareTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_square)

        squareTextView = findViewById(R.id.square_text_view)

        val number = intent.getIntExtra(Constants.NUMBER, 0)
        squareTextView.text = (number * number).toString()

        val switchToMainActivityButton = findViewById<Button>(R.id.switch_to_main_activity_button)
        switchToMainActivityButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(Constants.NUMBER, number)
            startActivity(intent)
        }
    }


    override fun onStart() {
        super.onStart()
        Log.d(tag, "onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "onDestroy")
    }
}
