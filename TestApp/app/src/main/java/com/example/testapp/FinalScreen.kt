package com.example.testapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class FinalScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_screen)

        val resultTextView: TextView =
                findViewById(R.id.endResults)

        val playAgain: Button =
                findViewById(R.id.playAgain)

        val sharedPreferences =
                getSharedPreferences(SHARED_PREFS_FILE, Context.MODE_PRIVATE)
        var score = sharedPreferences.getInt(KEY_SCORE, 0)
        println(score)

        playAgain.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
