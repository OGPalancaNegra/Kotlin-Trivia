package com.example.kotlintrivia.categories

import androidx.lifecycle.*
import com.example.kotlintrivia.model.*

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope

import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.awaitResponse

import java.lang.Exception
import kotlin.collections.ArrayList

class CategoryViewModel: ViewModel() {



    private val _navigateToSelectedProperty = MutableLiveData<List<com.example.kotlintrivia.model.Result>>()

    val navigateToSelectedProperty: LiveData<List<com.example.kotlintrivia.model.Result>> get() = _navigateToSelectedProperty

    private val _response = MutableLiveData<Assessment>()

    val response: LiveData<Assessment> get() = _response

    fun displayKnowledgeQuestion(){

        viewModelScope.launch {
            try {


            val data = GeneralKnowledgeQAPI.RETROFIT_SERVICE.getProperties()

            _navigateToSelectedProperty.value = data.awaitResponse().body()!!.results

            //_displayText.value = QuestionsApi.retrofitService.getTextList("What is the elemental symbol for mercury?")

            }catch (e: Exception){

                _navigateToSelectedProperty.value = ArrayList<com.example.kotlintrivia.model.Result>()
            }
        }
        }

    fun displayKnowledge(){

        GlobalScope.launch(Dispatchers.IO) {
            val response = GeneralKnowledgeQAPI.RETROFIT_SERVICE.getProperties().awaitResponse()
            if (response.isSuccessful){
                val data = response.body()!!.results

                withContext(Dispatchers.Main){
                    _navigateToSelectedProperty.value = data
                }
            }
        }
    }

    fun displayComputers(){

        GlobalScope.launch(Dispatchers.IO) {
            val response = ComputersQAPI.RETROFIT_SERVICE.getProperties().awaitResponse()
            if (response.isSuccessful){
                val data = response.body()!!.results
                withContext(Dispatchers.Main){
                    _navigateToSelectedProperty.value = data
                }
            }
        }
    }

    fun displayScience(){

        GlobalScope.launch(Dispatchers.IO) {
            val response = ScienceQAPI.RETROFIT_SERVICE.getProperties().awaitResponse()
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