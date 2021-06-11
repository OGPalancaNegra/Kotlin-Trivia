package com.example.kotlintrivia.categories

import android.app.Application
import androidx.lifecycle.*
import com.example.kotlintrivia.model.*

import com.google.gson.JsonObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope

import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.awaitResponse

import java.lang.Exception
import java.util.*
import kotlin.Result
import kotlin.collections.ArrayList

class CategoryViewModel: ViewModel() {



    private val _navigateToSelectedProperty = MutableLiveData<List<ResultX>>()

    val navigateToSelectedProperty: LiveData<List<ResultX>> get() = _navigateToSelectedProperty



    fun displayKnowledgeQuestion(){



        viewModelScope.launch {
            try {
            val data = QuestionsApi.retrofitService.getProperties().results

            _navigateToSelectedProperty.value = data

            //_displayText.value = QuestionsApi.retrofitService.getTextList("What is the elemental symbol for mercury?")

            }catch (e: Exception){
                _navigateToSelectedProperty.value = null
            }
        }
        }

    /*fun displayKnowledge(){

        GlobalScope.launch(Dispatchers.IO) {
            val response = QuestionsApi.retrofitService.getProperties().awaitResponse()
            if (response.isSuccessful){
                val data = response.body()!!
                //_navigateToSelectedProperty.value = data
            }

        }


    }*/


    fun displayQuestionsComplete() {
        _navigateToSelectedProperty.value = null
    }



}