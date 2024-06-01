package com.example.quizapp

object setData {
    const val name: String = "USER_NAME"
    const val score: String = "SCORE"

    fun getQuestion(): ArrayList<QuestionData> {
        val questionsList = ArrayList<QuestionData>()

        // Add sample questions here
        questionsList.add(
            QuestionData(
                1,
                "What is the capital of France?",
                "Berlin", "Madrid", "Paris", "Lisbon",
                3
            )
        )
        questionsList.add(
            QuestionData(
                2,
                "Which planet is known as the Red Planet?",
                "Earth", "Mars", "Jupiter", "Venus",
                2
            )
        )

        questionsList.add(
            QuestionData(
                3,
                "In what year did the Great October Socialist Revolution take place?",
                "1917", "1923", "1914", "1920",
                1
            )
        )
        questionsList.add(
            QuestionData(
                4,
                "What is the largest lake in the world?",
                "Caspian Sea", "Baikal", "Lake Superior", "Ontario",
                2
            )
        )

        questionsList.add(
            QuestionData(
                5,
                "What gas is used to extinguish fires??",
                "Oxygen", "Nitrogen", "Carbon dioxide", "Hydrogen",
                2
            )
        )
        // Add more questions

        return questionsList
    }
}
