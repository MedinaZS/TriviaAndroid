package com.roshka.triviaandroid

import android.content.Context

fun loadTriviaQuestions(context: Context): List<TriviaQuestion> {
    val questions: MutableList<TriviaQuestion> = mutableListOf()
    //Obtener array de arrays.xml
    val questionArray = context.resources.getStringArray(R.array.trivia_questions)


    for (i in questionArray.indices) {
        //Obtener la pregunta con sus opciones y respuesta
        val parts = questionArray[i].split("  ")
        if (i<2) {
            println(parts)
        }
//        val questionText = parts[0].trim()
//        val choices = parts[1].split(" ")
//        val answer = parts[2].trim().toInt()
//
//
//        val question = TriviaQuestion(questionText, choices, answer)
//        questions.add(question)
    }

    return questions
}


data class TriviaQuestion(val questionText: String, val choices: List<String>, val answer: Int)
