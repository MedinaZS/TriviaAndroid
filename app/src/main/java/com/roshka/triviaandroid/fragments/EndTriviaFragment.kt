package com.roshka.triviaandroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.roshka.triviaandroid.R

class EndTriviaFragment : Fragment() {

    private val args : EndTriviaFragmentArgs by navArgs()
    private var score = 0
    private lateinit var textResult : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflatedLayout = inflater.inflate(R.layout.fragment_end_trivia, container, false)

        textResult = inflatedLayout.findViewById(R.id.text_result)

        score = args.score

        textResult.text = getString(R.string.game_finish_message, score);

        return inflatedLayout
    }

}