package com.roshka.triviaandroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.roshka.triviaandroid.R


class StartTriviaFragment : Fragment() {

    private lateinit var buttonPlay : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var inflatedLayout = inflater.inflate(R.layout.fragment_start_trivia, container, false)

        buttonPlay = inflatedLayout.findViewById(R.id.button_play)

        buttonPlay.setOnClickListener { view ->
            Navigation.findNavController(view).navigate(R.id.action_startTriviaFragment_to_triviaFragment)
        }

        return inflatedLayout
    }

}