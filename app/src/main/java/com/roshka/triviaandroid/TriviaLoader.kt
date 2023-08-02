package com.roshka.triviaandroid

import android.content.Context

fun loadTriviaQuestions(context: Context): List<TriviaQuestion> {
    val questions: MutableList<TriviaQuestion> = mutableListOf()
    //Obtener array de arrays.xml
    val questionArray = context.resources.getStringArray(R.array.trivia_questions)


    for (i in questionArray.indices step 3) {
        // Obtener la pregunta con sus opciones y respuesta
        val questionText = questionArray[i].trim()
        val choices = questionArray[i + 1].split(", ")
        val answer = questionArray[i + 2].trim()

        val question = TriviaQuestion(questionText, choices, answer)
        questions.add(question)
    }

    return questions
}


data class TriviaQuestion(val questionText: String, val choices: List<String>, val answer: String)
