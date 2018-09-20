package com.example.testapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class GuessActivity : AppCompatActivity() {
    val myQuestions: Array<Question> = arrayOf(
        Question("What color is the wall?",
        arrayOf("Blue", "Green",  "Beige"),
        2),
        Question("What time was this question written?",
        arrayOf("2:34 PM", "4:30 PM",  "7:57PM"),
        0),
        Question("Why are we here?",
        arrayOf("To have fun",
        "To find love", "Where's my beer?"),
        2),
        Question("What dinosaur's name means 'egg thief'?",
        arrayOf("Velociraptor", "Oviraptor",
        "Deinonychus"),
        2),
        Question("Which one of these people is a time traveler?",
        arrayOf("Thomas Edison", "John Smith", "John Titor"),
        2)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guess)
        val sharedPreferences =
                getSharedPreferences(SHARED_PREFS_FILE, Context.MODE_PRIVATE)
        var questionIndex = sharedPreferences.getInt(KEY_QUESTION_INDEX, 0)

        // If we're out of questions, go immediately to FinalScreen
        val userGuessOne: Button =
                findViewById(R.id.A)

        val userGuessTwo: Button =
                findViewById(R.id.B)

        val userGuessThree: Button =
                findViewById(R.id.C)

        val userGuessTextOne: TextView =
                findViewById(R.id.answerA)

        val userGuessTextTwo: TextView =
                findViewById(R.id.answerB)

        val userGuessTextThree: TextView =
                findViewById(R.id.answerC)

        val questionText: TextView =
                findViewById(R.id.questionText)

        val myButtons: Array<Button> =
                arrayOf(userGuessOne, userGuessTwo, userGuessThree)

        val myTexts: Array<TextView> =
                arrayOf(userGuessTextOne, userGuessTextTwo, userGuessTextThree)

        for(i in 0..2){
            if(myQuestions[questionIndex].correctIndex == i) {
                myButtons[i].setOnClickListener{
                    val intent: Intent =
                            Intent(this, ResultsCorrect::class.java)
                    startActivity(intent)
                }
            }
            else {
                myButtons[i].setOnClickListener{
                    val intent: Intent =
                            Intent(this, ResultsIncorrect::class.java)
                    startActivity(intent)
                }
            }
            myTexts[i].text = myQuestions[questionIndex].options[i]
        }

        questionText.text = myQuestions[questionIndex].questionText
        val editor = sharedPreferences.edit()
        editor.putInt(KEY_QUESTION_INDEX, ++questionIndex)
        editor.apply()
    }
}
