package com.example.kotlintrivia.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Result(
    val category: String,
    val correct_answer: String,
    val difficulty: String,
    var incorrect_answers: List<String>,
    val question: String,
    val type: String
):Parcelable