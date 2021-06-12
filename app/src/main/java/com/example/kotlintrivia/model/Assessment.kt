package com.example.kotlintrivia.model

data class Assessment(
    val response_code: Int,
    val results: List<Result>
)