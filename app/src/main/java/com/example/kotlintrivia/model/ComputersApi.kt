package com.example.kotlintrivia.model

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


private const val BASE_URL = "https://opentdb.com/"

/* working:
    "https://api.github.com/"
    "https://mars.udacity.com/"
 */



/**
 * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
 * full Kotlin compatibility.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
 * object.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

/**
 * A public interface that exposes the [getProperties] method
 */
interface ComputersAPIService {
    @GET("api.php?amount=10&category=18&difficulty=easy&type=multiple")
    fun getProperties(): Call<Assessment>
}

// general knowledge string: api.php?amount=10&category=21&difficulty=easy&type=multiple

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object ComputersQAPI {
    val RETROFIT_SERVICE : ComputersAPIService by lazy  { retrofit.create(ComputersAPIService::class.java) }
}
