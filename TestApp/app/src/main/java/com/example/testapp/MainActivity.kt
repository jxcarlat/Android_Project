package com.example.testapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.util.*

const val SHARED_PREFS_FILE = "com.example.testapp.SHARED_PREFS"
const val KEY_ANSWER = "com.example.testapp.KEY_ANSWER"
const val KEY_GUESS = "com.example.testapp.KEY_GUESS"



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startGame(view: View) {

        val sharedPreferences =
                getSharedPreferences(SHARED_PREFS_FILE, Context.MODE_PRIVATE)

        val editor = sharedPreferences.edit()
        editor.putInt(KEY_ANSWER, theAnswer)
        editor.apply()

        val intent = Intent(this, GuessActivity::class.java)
        startActivity(intent)
    }



}