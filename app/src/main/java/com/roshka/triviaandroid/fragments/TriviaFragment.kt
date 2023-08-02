package com.roshka.triviaandroid.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.roshka.triviaandroid.R
import com.roshka.triviaandroid.TriviaQuestion
import com.roshka.triviaandroid.loadTriviaQuestions


class TriviaFragment : Fragment() {

    private lateinit var textQuestion: TextView
    private lateinit var textScore: TextView
    private lateinit var buttonAnswer1: Button
    private lateinit var buttonAnswer2: Button
    private lateinit var buttonAnswer3: Button
    private lateinit var buttonAnswer4: Button

    private var turn = 0
    private var score = 0

    private var quiz : List<TriviaQuestion> = mutableListOf()

//    private val quiz2 = arrayOf(
//        mutableMapOf(
//            "question" to "¿Cuántas franjas tiene la bandera de Estados Unidos?",
//            "choices" to listOf("12", "14", "11", "13"),
//            "correct" to "13"
//        ),
//        mutableMapOf(
//            "question" to "¿Cuál es el río más largo del mundo?",
//            "choices" to listOf("Nilo", "Amazonas", "Misisipi", "Yangtsé"),
//            "correct" to "Nilo"
//        ),
//        mutableMapOf(
//            "question" to "¿Cuál es el animal terrestre más rápido del mundo?",
//            "choices" to listOf("Guepardo", "León", "Rinoceronte", "Venado"),
//            "correct" to "Guepardo"
//        )
//    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflatedView = inflater.inflate(R.layout.fragment_trivia, container, false)

        // get views
        textQuestion = inflatedView.findViewById(R.id.text_question)
        textScore = inflatedView.findViewById(R.id.text_score)
        buttonAnswer1 = inflatedView.findViewById(R.id.button_answer_1)
        buttonAnswer2 = inflatedView.findViewById(R.id.button_answer_2)
        buttonAnswer3 = inflatedView.findViewById(R.id.button_answer_3)
        buttonAnswer4 = inflatedView.findViewById(R.id.button_answer_4)

        buttonAnswer1.setOnClickListener { checkAnswer(buttonAnswer1) }
        buttonAnswer2.setOnClickListener { checkAnswer(buttonAnswer2) }
        buttonAnswer3.setOnClickListener { checkAnswer(buttonAnswer2) }
        buttonAnswer4.setOnClickListener { checkAnswer(buttonAnswer4) }

        // Colocar Score inicial
        textScore.text = getString(R.string.score, score)

        // Obtener las preguntas desde el recurso de tipo array usando la función en "TriviaLoader.kt"
        quiz = loadTriviaQuestions(requireContext())

        playTurn()

        return inflatedView
    }

    private fun playTurn() {
        println(quiz.size)
        if (turn < quiz.size) {
            textQuestion.text = quiz[turn].questionText

            buttonAnswer1.text = quiz[turn].choices[0]
            buttonAnswer2.text = quiz[turn].choices[1]
            buttonAnswer3.text = quiz[turn].choices[2]
            buttonAnswer4.text = quiz[turn].choices[3]
        } else {
            val direction = TriviaFragmentDirections.actionTriviaFragmentToEndTriviaFragment(score)
            findNavController().navigate(direction)
        }
    }


    private fun checkAnswer(button: Button) {
        if (turn < quiz.size) {
            //obtener el indice de la respuesta correcta
            val indexCorrect = quiz[turn].answer

            if (button.text == quiz[turn].choices[indexCorrect])
                score++

            textScore.text = getString(R.string.score, score)

            turn++

            playTurn()
        }

    }


}