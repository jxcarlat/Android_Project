package com.example.testapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*


class ResultsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_results)
    }

    override fun onResume() {
        super.onResume()

        val resultTextView: TextView =
                findViewById(R.id.resultTextView)
        val nextButton : Button =
                findViewById(R.id.nextButton)

        val sharedPreferences =
                getSharedPreferences(SHARED_PREFS_FILE, Context.MODE_PRIVATE)

        val theAnswer: Boolean = sharedPreferences.getBoolean(KEY_ANSWER, false)
        val userGuess: Boolean = sharedPreferences.getBoolean(KEY_GUESS, false)

        val userIsCorrect: Boolean =
                (theAnswer == userGuess)

        if(userIsCorrect) {
            // Update resultTextView and nextButton to show
            // that they were correct
            resultTextView.text = "Good Guess!  You Win!"
            nextButton.text = "Start Over"
            nextButton.setOnClickListener {
                val intent: Intent =
                        Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
        else {
            resultTextView.text = "Nope, try again!"
            nextButton.text = "Try Again"
            nextButton.setOnClickListener {
                val intent: Intent =
                        Intent(this, GuessActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
