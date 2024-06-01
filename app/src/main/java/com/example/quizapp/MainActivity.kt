package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import com.example.quizapp.activites.QuestionViewActivity

//import com.example.quizapp.R

class MainActivity : AppCompatActivity() {
//Change 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton: Button = findViewById(R.id.startButton)
        val nameEditText: EditText = findViewById(R.id.nameEditText)

        startButton.setOnClickListener {
            val intent = Intent(this, QuestionViewActivity::class.java)
            intent.putExtra("USER_NAME", nameEditText.text.toString())
            startActivity(intent)
            finish()
        }
    }
}
