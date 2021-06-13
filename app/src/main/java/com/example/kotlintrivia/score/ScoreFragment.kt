package com.example.kotlintrivia.score

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.kotlintrivia.R
import com.example.kotlintrivia.databinding.FragmentScoreBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class ScoreFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val scoreBinding = FragmentScoreBinding.inflate(inflater)

        val passedScore = arguments?.getInt("correct")

        scoreBinding.scoreText.text = "You scored ${passedScore.toString()}/10"






        return scoreBinding.root
    }

}