package com.example.kotlintrivia.model

import java.util.*

public interface AnswerListAsyncResponse {
    fun processFinished(questionArrayList: List<Questions>)
}