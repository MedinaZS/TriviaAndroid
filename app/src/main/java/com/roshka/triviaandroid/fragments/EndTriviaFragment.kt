package com.roshka.triviaandroid.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.roshka.triviaandroid.R

class EndTriviaFragment : Fragment() {

    private val args: EndTriviaFragmentArgs by navArgs()
    private var score = 0
    private lateinit var textResult: TextView
    private lateinit var mainLayout: ConstraintLayout
    private lateinit var buttonPlayAgain: Button
    private lateinit var buttonShare: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflatedLayout = inflater.inflate(R.layout.fragment_end_trivia, container, false)

        textResult = inflatedLayout.findViewById(R.id.text_result)
        mainLayout = inflatedLayout.findViewById(R.id.main_layout)
        buttonPlayAgain = inflatedLayout.findViewById(R.id.button_play_again)
        buttonShare = inflatedLayout.findViewById(R.id.imageButton_share)

        score = args.score

        //Navegar al fragment de inicio de trivia
        buttonPlayAgain.setOnClickListener { view ->
            Navigation.findNavController(view)
                .navigate(R.id.action_endTriviaFragment_to_startTriviaFragment)
        }

        //Compartir puntuacion
        buttonShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.setType("text/plain")
                .putExtra(Intent.EXTRA_TEXT, "Este es mi resultado en la trivia!! Obtuve $score puntos.")

            startActivity(shareIntent)
        }

        //Mostrar el puntaje en el fragment
        showScore()

        return inflatedLayout
    }

    private fun showScore() {
        textResult.text = score.toString()
    }

}