package com.example.testapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.view.*

class GuessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guess)
    }

    fun getGuess(view: View) {
        val userGuessOne: Button =
                findViewById(R.id.A)

        val userGuessTwo: Button =
                findViewById(R.id.B)

        val userGuessThree: Button =
                findViewById(R.id.C)

        val sharedPreferences =
                getSharedPreferences(SHARED_PREFS_FILE, Context.MODE_PRIVATE)

        val editor = sharedPreferences.edit()
        editor.putBoolean(KEY_GUESS, userGuessOne.isPressed.equals(true))
        editor.putBoolean(KEY_GUESS, userGuessTwo.isPressed.equals(false))
        editor.putBoolean(KEY_GUESS, userGuessThree.isPressed.equals(false))
        editor.apply()

        val intent: Intent =
                Intent(this, ResultsActivity::class.java)
        startActivity(intent)
    }
}
