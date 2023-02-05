package com.github.task2

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object IntentCreator {
        const val NUMBER = "number"
        fun createIntent(packageContext: Context, number: Int): Intent {
            val intent = Intent(packageContext, MainActivity::class.java)
            intent.putExtra(NUMBER, number)
            return intent
        }
    }

    private val tag = this.javaClass.simpleName
    private var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        number = savedInstanceState?.getInt(NUMBER)
            ?: intent?.getIntExtra(NUMBER, 0)
            ?: 0
        Log.d(tag, "onCreate, number=$number")
        updateNumberTextOnView()

        val switchToSquareActivityButton = findViewById<Button>(R.id.switch_to_square_activity_button)
        switchToSquareActivityButton.setOnClickListener {
            val intent = Intent(this, SquareActivity::class.java)
            intent.putExtra(NUMBER, number)
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(tag, "onSaveInstanceState, number=$number")
        outState.putInt(NUMBER, number)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        number = savedInstanceState.getInt(NUMBER)
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