package com.example.testapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ResultsIncorrect : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results_incorrect)
        val tryAgain: Button =
                findViewById(R.id.tryAgain)
        tryAgain.setOnClickListener {
            val intent = Intent(this, GuessActivity::class.java)
            startActivity(intent)
        }
    }
}
