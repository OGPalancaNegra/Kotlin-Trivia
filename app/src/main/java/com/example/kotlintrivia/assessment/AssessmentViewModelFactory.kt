package com.example.kotlintrivia.assessment

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlintrivia.databinding.FragmentAssessmentBinding
import com.example.kotlintrivia.model.Result


class AssessmentViewModelFactory(
    private val selectedQuestionList: MutableList<Result>,
    private val application: Application, private val assessmentBinding: FragmentAssessmentBinding
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AssessmentViewModel::class.java)) {
            return AssessmentViewModel(selectedQuestionList, application, assessmentBinding) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}