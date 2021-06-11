package com.example.kotlintrivia.model

import com.google.gson.annotations.SerializedName

data class Result(@SerializedName("result")
                    val mResult: ArrayList<Questions>)
