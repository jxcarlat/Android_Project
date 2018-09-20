package com.example.testapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.testapp.R
import java.util.Random

const val SHARED_PREFS_FILE = "com.example.testapp.SHARED_PREFS"
const val KEY_SCORE = "com.example.testapp.KEY_SCORE"
const val KEY_QUESTION_INDEX = "com.example.testapp.KEY_QUESTION_INDEX"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startGame(view: View) {

        //Set score to 0 in shared preferences
        val sharedPreferences =
                getSharedPreferences(SHARED_PREFS_FILE, Context.MODE_PRIVATE)


        val editor = sharedPreferences.edit()
        editor.putInt(KEY_SCORE, 0)
        editor.putInt(KEY_QUESTION_INDEX, 0)
        editor.apply()
        val intent = Intent(this, GuessActivity::class.java)
        startActivity(intent)
    }

}
