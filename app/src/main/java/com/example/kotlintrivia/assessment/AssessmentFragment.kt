package com.example.kotlintrivia.assessment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.kotlintrivia.R
import com.example.kotlintrivia.databinding.FragmentAssessmentBinding
import com.example.kotlintrivia.model.Result

class AssessmentFragment : Fragment() {

    // create variables for current question, answers, question index and number of questions


    private lateinit var questions: MutableList<Result>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val assessmentBinding = FragmentAssessmentBinding.inflate(inflater)

        //return inflater.inflate(R.layout.fragment_assessment, container, false)

        assessmentBinding.lifecycleOwner = this

        val application = requireNotNull(activity).application

        questions =
            AssessmentFragmentArgs.fromBundle(requireArguments()).questionList.toMutableList()

        val assessmentViewModelFactory = AssessmentViewModelFactory(questions, application, assessmentBinding)

        val assessmentViewModel =
            ViewModelProvider(this, assessmentViewModelFactory).get(AssessmentViewModel::class.java)

        assessmentBinding.assessmentViewModel = assessmentViewModel



        /* assessmentViewModel.correctScore.observe(viewLifecycleOwner, Observer {
                assessmentBinding.correctAnswer2.text = assessmentViewModel.correctScore.toString()
         })*/
        assessmentViewModel.eventGameFinish.observe(viewLifecycleOwner, Observer { isFinished ->
            if (isFinished){
                //val correctAnswers = assessmentViewModel.correctAnswers
                //val action = AssessmentFragmentDirections.actionAssessmentFragmentToScoreFragment(correctAnswers)
                val correctscore = assessmentViewModel.correctScore.value ?: 0
                val bundle = bundleOf("correct" to correctscore)
                this.findNavController().navigate(R.id.action_assessmentFragment_to_scoreFragment, bundle)
                assessmentViewModel.onGameFinishComplete()
            }
        })

        return assessmentBinding.root
    }

}


