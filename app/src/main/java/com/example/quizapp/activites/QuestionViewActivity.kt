package com.example.quizapp.activites

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.quizapp.QuestionData
import com.example.quizapp.R
import com.example.quizapp.ResultActivity
import com.example.quizapp.setData

class QuestionViewActivity : AppCompatActivity() {
    private var userName: String? = null
    private var score: Int = 0
    private var currentPosition: Int = 1
    private var questionList: ArrayList<QuestionData>? = null
    private var selectedOption: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_view)

        userName = intent.getStringExtra("USER_NAME")
        questionList = setData.getQuestion()

        setQuestion()

        findViewById<TextView>(R.id.opt_1).setOnClickListener {
            selectedOptionStyle(findViewById(R.id.opt_1), 1)
        }
        findViewById<TextView>(R.id.opt_2).setOnClickListener {
            selectedOptionStyle(findViewById(R.id.opt_2), 2)
        }
        findViewById<TextView>(R.id.opt_3).setOnClickListener {
            selectedOptionStyle(findViewById(R.id.opt_3), 3)
        }
        findViewById<TextView>(R.id.opt_4).setOnClickListener {
            selectedOptionStyle(findViewById(R.id.opt_4), 4)
        }

        findViewById<TextView>(R.id.submit).setOnClickListener {
            if (selectedOption != 0) {
                val question = questionList!![currentPosition - 1]
                if (selectedOption != question.correctAnswer) {
                    setColor(selectedOption, R.drawable.wrong_question_option)
                } else {
                    score++
                }
                setColor(question.correctAnswer, R.drawable.correct_question_option)
                if (currentPosition == questionList!!.size) {
                    findViewById<TextView>(R.id.submit).text = "FINISH"
                } else {
                    findViewById<TextView>(R.id.submit).text = "NEXT"
                }
            } else {
                currentPosition++
                when {
                    currentPosition <= questionList!!.size -> {
                        setQuestion()
                    }
                    else -> {
                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra("USER_NAME", userName)
                        intent.putExtra("SCORE", score.toString())
                        intent.putExtra("TOTAL_QUESTIONS", questionList!!.size.toString())
                        startActivity(intent)
                        finish()
                    }
                }
            }
            selectedOption = 0
        }
    }

    private fun setColor(option: Int, color: Int) {
        when (option) {
            1 -> findViewById<TextView>(R.id.opt_1).background = ContextCompat.getDrawable(this, color)
            2 -> findViewById<TextView>(R.id.opt_2).background = ContextCompat.getDrawable(this, color)
            3 -> findViewById<TextView>(R.id.opt_3).background = ContextCompat.getDrawable(this, color)
            4 -> findViewById<TextView>(R.id.opt_4).background = ContextCompat.getDrawable(this, color)
        }
    }

    private fun setQuestion() {
        val question = questionList!![currentPosition - 1]
        setOptionStyle()

        val progressBar: ProgressBar = findViewById(R.id.progress_bar)
        progressBar.progress = currentPosition
        progressBar.max = questionList!!.size
        findViewById<TextView>(R.id.progress_text).text = "$currentPosition/${questionList!!.size}"
        findViewById<TextView>(R.id.question_text).text = question.question
        findViewById<TextView>(R.id.opt_1).text = question.optionOne
        findViewById<TextView>(R.id.opt_2).text = question.optionTwo
        findViewById<TextView>(R.id.opt_3).text = question.optionThree
        findViewById<TextView>(R.id.opt_4).text = question.optionFour
    }

    private fun setOptionStyle() {
        val optionList: ArrayList<TextView> = arrayListOf(
            findViewById(R.id.opt_1),
            findViewById(R.id.opt_2),
            findViewById(R.id.opt_3),
            findViewById(R.id.opt_4)
        )

        for (option in optionList) {
            option.setTextColor(Color.parseColor("#555151"))
            option.background = ContextCompat.getDrawable(this, R.drawable.question_option)
            option.typeface = Typeface.DEFAULT
        }
    }

    private fun selectedOptionStyle(view: TextView, option: Int) {
        setOptionStyle()
        selectedOption = option
        view.background = ContextCompat.getDrawable(this, R.drawable.selected_question_option)
        view.typeface = Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))
    }


}