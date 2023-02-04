package com.github.task2

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val tag = this.javaClass.simpleName
    private var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(tag, "onCreate")
        setContentView(R.layout.activity_main)

        number = savedInstanceState?.getInt(Constants.NUMBER)
            ?: if (intent != null)
                intent.getIntExtra(Constants.NUMBER, 0)
            else 0
        updateNumberTextOnView()

        val switchToSquareActivityButton = findViewById<Button>(R.id.switch_to_square_activity_button)
        switchToSquareActivityButton.setOnClickListener {
            val intent = Intent(this, SquareActivity::class.java)
            intent.putExtra(Constants.NUMBER, number)
            startActivity(intent)
        }
    }

    private fun updateNumberTextOnView() {
        val numberTextView: TextView = findViewById(R.id.number_text_view)
        numberTextView.text = number.toString()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        number++
        Log.i(tag, "onConfigurationChanged number=$number")
        updateNumberTextOnView()
        super.onConfigurationChanged(newConfig)
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "onResume")
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