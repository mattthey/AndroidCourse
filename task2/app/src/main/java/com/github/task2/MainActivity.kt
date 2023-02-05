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
        setContentView(R.layout.activity_main)

        number = savedInstanceState?.getInt(Constants.NUMBER)
            ?: intent?.getIntExtra(Constants.NUMBER, 0)
            ?: 0
        Log.d(tag, "onCreate, number=$number")
        updateNumberTextOnView()

        val switchToSquareActivityButton = findViewById<Button>(R.id.switch_to_square_activity_button)
        switchToSquareActivityButton.setOnClickListener {
            val intent = Intent(this, SquareActivity::class.java)
            intent.putExtra(Constants.NUMBER, number)
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(tag, "onSaveInstanceState, number=$number")
        outState.putInt(Constants.NUMBER, number)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        number = savedInstanceState.getInt(Constants.NUMBER)
        Log.d(tag, "onRestoreInstanceState, number=$number")
        updateNumberTextOnView()
        super.onRestoreInstanceState(savedInstanceState)
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