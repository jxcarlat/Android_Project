package com.example.testapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*


class ResultsCorrect : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_results)

        var resultTextView: TextView =
                findViewById(R.id.textView)
        val nextButton: Button =
                findViewById(R.id.nextButton)

        val sharedPreferences =
                getSharedPreferences(SHARED_PREFS_FILE, Context.MODE_PRIVATE)
        var score = sharedPreferences.getInt(KEY_SCORE, 0)

        val editor = sharedPreferences.edit()
        editor.putInt(KEY_SCORE, ++score)
        editor.apply()

        nextButton.setOnClickListener {
            val intent = Intent(this, GuessActivity::class.java)
            startActivity(intent)
        }
    }



    }
