package com.example.kotlintrivia.assessment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.kotlintrivia.R
import com.example.kotlintrivia.databinding.FragmentAssessmentBinding
import com.example.kotlintrivia.model.Questions

class AssessmentFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val assessmentBinding = FragmentAssessmentBinding.inflate(inflater)
        //return inflater.inflate(R.layout.fragment_assessment, container, false)

        val application = requireNotNull(activity).application

        assessmentBinding.lifecycleOwner = this

        val selectedQuestion = AssessmentFragmentArgs.fromBundle(requireArguments()).questionList

        assessmentBinding.dummyCorrect.text = selectedQuestion.toList()[0].question

//        selectedQuestion.set(1, Questions("nothing", "something", listOf("1","2"))).toString()

        //assessmentBinding.dummyIncorrect.text = selectedQuestion.toString()

        //val assessmentViewModelFactory = AssessmentViewModelFactory(selectedQuestion.to, application)


        //assessmentBinding.assessmentViewModel = ViewModelProvider(this, assessmentViewModelFactory).get(AssessmentViewModel::class.java)


        return assessmentBinding.root
    }


    override fun toString(): String {
        return "Questions{" +
                "text='" + Questions("nothing","this", listOf("this","that")).text + '\'' +
                ", correct answer ="
                '}'
    }




}