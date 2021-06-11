package com.example.kotlintrivia.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName

import kotlinx.android.parcel.Parcelize


data class Questions(
    @SerializedName("question")
    val text: String,
    @SerializedName("correct_answer")
    val correctAnswer: String,
    @SerializedName("incorrect_answers")
    val wrongAnswerList: List<String>)

/*@Parcelize
class QuestionsClass: ArrayList<Questions>(), Parcelable*/

