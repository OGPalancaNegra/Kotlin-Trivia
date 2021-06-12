package com.example.kotlintrivia.assessment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.navigation.findNavController
import com.example.kotlintrivia.R
import com.example.kotlintrivia.databinding.FragmentAssessmentBinding
import com.example.kotlintrivia.model.Result

class AssessmentFragment : Fragment() {

    // create variables for current question, answers, question index and number of questions

    lateinit var currentQuestion: com.example.kotlintrivia.model.Result
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private var answerOptionIndex = 0
    private lateinit var questions: List<Result>
    var correctAnswers: Int = 0
    var numQuestions = 10

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val assessmentBinding = FragmentAssessmentBinding.inflate(inflater)
        //return inflater.inflate(R.layout.fragment_assessment, container, false)

        val application = requireNotNull(activity).application


        //val assessmentViewModelFactory = AssessmentViewModelFactory(selectedQuestion.to, application)


        //assessmentBinding.assessmentViewModel = ViewModelProvider(this, assessmentViewModelFactory).get(AssessmentViewModel::class.java)

        assessmentBinding.assessmentFragment = this

        assessmentBinding.lifecycleOwner = this



        questions = AssessmentFragmentArgs.fromBundle(requireArguments()).questionList.toList()



        // TO DISPLAY CURRENT QUESTIONS AND ANSWERS IN TING NEED list of possible answers

        // since couldnt do try to add correct answer string to single list of question

       // questions[answerOptionIndex].incorrect_answers += questions[answerOptionIndex].correct_answer


        randomizedQuestions()


        // Set the onClickListener for the submitButton
        assessmentBinding.submitButton.setOnClickListener { view: View ->

            // if user selected answer is == to correct answer add to score and move onto next question

            // else dont add to score and move onto next quesiotn


            // get user checked button
            val checkedId= assessmentBinding.questionRadioGroup.checkedRadioButtonId
            // Do nothing if nothing is checked (id == -1)
            if (-1 != checkedId) {
                var answerIndex = 0

                // set the answer index either one of the selected radio buttons to
                // allow compare to correct answer later
                when (checkedId) {
                    R.id.secondAnswerRadioButton -> answerIndex = 1
                    R.id.thirdAnswerRadioButton -> answerIndex = 2
                    R.id.fourthAnswerRadioButton -> answerIndex = 3
                }

                // in incorrect answers the 3rd one is always the correct answer

                if (answers[answerIndex] == currentQuestion.incorrect_answers[3]) {
                        questionIndex++
                    if (questionIndex < numQuestions) {

                        correctAnswers++
                        nextQuestion()
                        assessmentBinding.invalidateAll()
                    }

                    else {
                        // We've won!  Navigate to the gameWonFragment.
                        view.findNavController().navigate(AssessmentFragmentDirections.actionAssessmentFragmentToScoreFragment())
                    }


                } else {


                    questionIndex++

                    if (questionIndex < numQuestions) {
                        nextQuestion()
                        assessmentBinding.invalidateAll()
                    }

                    else {
                        // We've won!  Navigate to the gameWonFragment.
                        view.findNavController().navigate(AssessmentFragmentDirections.actionAssessmentFragmentToScoreFragment())
                    }
                }

            }

        }

        return assessmentBinding.root
    }


    private fun randomizedQuestions(){
        // randomze questions and set the first question

        questions.toMutableList().shuffle()
        answerOptionIndex = 0
        questionIndex = 0
        setQuestion()

    }
    private fun setQuestion() {
        questions[answerOptionIndex].incorrect_answers += questions[answerOptionIndex].correct_answer

        currentQuestion = questions[questionIndex]
        // randomize the answers into a copy of the array
        answers = currentQuestion.incorrect_answers.toMutableList()
        // and shuffle them
        answers.shuffle()

    }

    private fun nextQuestion(){
        answerOptionIndex++
        currentQuestion = questions[questionIndex]
        setQuestion()

    }

    fun selectedOption(radioGroup: RadioGroup, id:Int){
        radioGroup.check(id)

    }







}


