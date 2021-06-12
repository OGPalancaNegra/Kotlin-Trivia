package com.example.kotlintrivia.assessment

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlintrivia.model.GeneralKnowledge


class AssessmentViewModelFactory(
    private val selectedQuestionList: List<GeneralKnowledge>,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AssessmentViewModel::class.java)) {
            return AssessmentViewModel(selectedQuestionList, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}