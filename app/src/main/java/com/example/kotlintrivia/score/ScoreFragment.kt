package com.example.kotlintrivia.score

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.kotlintrivia.R
import com.example.kotlintrivia.databinding.FragmentScoreBinding



class ScoreFragment : Fragment() {

    private lateinit var scoreViewModel: ScoreViewModel
    private lateinit var scoreViewModelFactory: ScoreViewModelFactory


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val scoreBinding = FragmentScoreBinding.inflate(inflater)

        scoreBinding.lifecycleOwner = this


        val passedScore = arguments?.getInt("correct")

        scoreViewModelFactory = passedScore?.let { ScoreViewModelFactory(it) }!!

        scoreViewModel = ViewModelProvider(this, scoreViewModelFactory).get(ScoreViewModel::class.java)

        scoreBinding.scoreViewModel = scoreViewModel


        scoreViewModel.eventPlayAgain.observe(viewLifecycleOwner, Observer { playAgain ->
            if (playAgain) {
                findNavController().navigate(ScoreFragmentDirections.actionScoreFragmentToCategoryFragment())
                scoreViewModel.onTestAgainComplete()
            }
        })

        scoreViewModel.exitApp.observe(viewLifecycleOwner, Observer { exitApp ->
            if (exitApp){
                activity?.finish()
            }
        })






        return scoreBinding.root
    }

}