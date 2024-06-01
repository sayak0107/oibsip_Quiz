package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val userName = intent.getStringExtra("USER_NAME")
        val score = intent.getStringExtra("SCORE")
        val totalQuestions = intent.getStringExtra("TOTAL_QUESTIONS")

        findViewById<TextView>(R.id.congratulations_text).text = "Congratulations, $userName!"
        findViewById<TextView>(R.id.score_text).text = "Your Score: $score / $totalQuestions"

        findViewById<Button>(R.id.play_again_button).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
