package com.example.kotlintrivia.assessment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlintrivia.model.Questions


class AssessmentViewModel(selectedQuestionList: List<Questions>, app: Application): AndroidViewModel(app) {

    private val _selectedQuestions = MutableLiveData<List<Questions>>()

    // The external LiveData for the SelectedProperty
    val selectedQuestions: LiveData<List<Questions>>
        get() = _selectedQuestions

    // Initialize the _selectedProperty MutableLiveData
    init {
        _selectedQuestions.value = selectedQuestionList
    }

}