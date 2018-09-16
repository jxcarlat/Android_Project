package com.example.testapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val resultTextView: TextView =
                findViewById(R.id.resultTextView)
        val nextButton: Button =
                findViewById(R.id.button6)

        val sharedPreferences =
                getSharedPreferences(SHARED_PREFS_FILE, Context.MODE_PRIVATE)

        val theAnswer: String = sharedPreferences.getString(KEY_ANSWER, "")
        val userGuess: String = sharedPreferences.getString(KEY_GUESS, "")

        val userIsCorrect: Boolean =
                (theAnswer == userGuess)

        if(userIsCorrect)
        {
            //Update resultTextView and nextButton to show
            // that they were correct
            resultTextView.text = "Good Guess! You Win!"
            nextButton.text = "Start Over"
            nextButton.setOnClickListener{
                val intent: Intent =
                        Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
        else
        {
            resultTextView.text = "Nope, try again!"
            nextButton.text = "Try again"
            nextButton.setOnClickListener{
                val intent: Intent =
                        Intent(this, GuessActivity::class.java)
                startActivity(intent)
            }
        }
        setContentView(R.layout.activity_results)


    }
}
