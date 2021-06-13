package com.example.kotlintrivia.assessment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import com.example.kotlintrivia.databinding.FragmentAssessmentBinding
import com.example.kotlintrivia.model.Result


class AssessmentViewModel(selectedQuestionList: MutableList<Result>, app: Application, assessmentBinding: FragmentAssessmentBinding): AndroidViewModel(app) {

    private val _questions = MutableLiveData<MutableList<Result>>()

    // The external LiveData for the SelectedProperty
    val questions: LiveData<MutableList<Result>>
        get() = _questions

    val assessmentBinding: FragmentAssessmentBinding = assessmentBinding



    val _answerIndex = MutableLiveData<Int>()
    val answerIndex: LiveData<Int>
        get() = _answerIndex

    var questionIndex = 0
    private var answerOptionIndex = 0

    lateinit var currentQuestion: com.example.kotlintrivia.model.Result
    lateinit var answers: MutableList<String>

    private val _correctscore = MutableLiveData<Int>()
    val correctScore: LiveData<Int>
        get() = _correctscore

    var numQuestions = 10

    private val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish: LiveData<Boolean>
        get() = _eventGameFinish

    // Initialize the _selectedProperty MutableLiveData
    init {
        _questions.value = selectedQuestionList
        randomizedQuestions()
        _correctscore.value = 0

    }

    fun setAnswerIndex(selectedIndex: Int){
        _answerIndex.value = selectedIndex
    }

    fun submitAnswer(assessmentBinding: FragmentAssessmentBinding) {
        if (answers[_answerIndex.value!!] == currentQuestion.incorrect_answers[3]) {
            questionIndex++
            if (questionIndex < numQuestions) {
                _correctscore.value = (_correctscore.value)?.plus(1)
                nextQuestion()
                assessmentBinding.invalidateAll()

            } else {
                _eventGameFinish.value = true
            }
        }
            else {
                questionIndex++

                if (questionIndex < numQuestions) {
                    nextQuestion()
                    assessmentBinding.invalidateAll()

                } else {
                    _eventGameFinish.value = true
                }
            }

        }


    fun randomizedQuestions(){
        // randomze questions and set the first question
        _questions.value?.shuffle()
        answerOptionIndex = 0
        questionIndex = 0
        setQuestion()

    }

    fun setQuestion() {
        _questions.value!![answerOptionIndex].incorrect_answers += _questions.value!![answerOptionIndex].correct_answer

        currentQuestion = _questions.value!![questionIndex]
        // randomize the answers into a copy of the array
        answers = currentQuestion.incorrect_answers.toMutableList()
        // and shuffle them
        answers.shuffle()

    }

    private fun nextQuestion(){
        answerOptionIndex++
        currentQuestion = _questions.value!![questionIndex]
        setQuestion()

    }


    fun onGameFinishComplete() {
        _eventGameFinish.value = false
    }



}