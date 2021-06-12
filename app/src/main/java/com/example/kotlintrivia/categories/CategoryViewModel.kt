package com.example.kotlintrivia.categories

import android.app.Application
import androidx.lifecycle.*
import com.example.kotlintrivia.model.*

import com.google.gson.JsonObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope

import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.awaitResponse

import java.lang.Exception
import java.util.*
import kotlin.Result
import kotlin.collections.ArrayList

class CategoryViewModel: ViewModel() {



    private val _navigateToSelectedProperty = MutableLiveData<List<com.example.kotlintrivia.model.Result>>()

    val navigateToSelectedProperty: LiveData<List<com.example.kotlintrivia.model.Result>> get() = _navigateToSelectedProperty

    private val _response = MutableLiveData<GeneralKnowledge>()

    val response: LiveData<GeneralKnowledge> get() = _response

    fun displayKnowledgeQuestion(){

        viewModelScope.launch {
            try {


            val data = QuestionsApi.retrofitService.getProperties()

            _navigateToSelectedProperty.value = data.awaitResponse().body()!!.results

            //_displayText.value = QuestionsApi.retrofitService.getTextList("What is the elemental symbol for mercury?")

            }catch (e: Exception){

                _navigateToSelectedProperty.value = ArrayList<com.example.kotlintrivia.model.Result>()
            }
        }
        }

    fun displayKnowledge(){

        GlobalScope.launch(Dispatchers.IO) {
            val response = QuestionsApi.retrofitService.getProperties().awaitResponse()
            if (response.isSuccessful){
                val data = response.body()!!.results

                withContext(Dispatchers.Main){
                    _navigateToSelectedProperty.value = data
                }

            }

        }


    }


    fun displayQuestionsComplete() {
        _navigateToSelectedProperty.value = null
    }



}