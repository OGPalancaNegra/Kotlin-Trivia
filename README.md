# Trivia - MVVM, Json Trivia API, Retrofit, Kotlin Courtines
Kotlin Trivia application that retrieves a Trivia Json Object from an API with Retrofit and Kotlin Courtines and converts it to a kotlin list with Gson Converter library to display onto the user screen
# Features
* Get Json Object From json Api
* Display User Selected Category questions onto the screen
* Navigate Between fragments with Navigation JetPack library
* Navigate to game over fragment after questions run out
* Display user correct Score
# Technical Feature
Implement Jetpack libraries Navigation, Databinding and Lifecycle to respectively navigate between pages, Connect the layout with the kotlin file and allow main kotlin file to watch viewmodel variable to act on changes
# App Packages
* assessment : Holds all the logic related to the assessment side of the app such as the move onto next question function
* categories: Contains logic to display the question related to the user selected category
* databinding: Contains generated Databinding logic
* model: Contains Assessment and Result dataclasses for the retrieved json objects
* repo: Contains all the logic to retieve JSON object data from a Json Api
* score: Contains all the logic related to the score of the app
# Library Reference
* Jetpack Databinding
* Jetpack Lifecycle
* Jetpack Navigation
* Retrofit
* Gson Converter
* Moshi
* Kotlin Courtines
# App Images
![category selection](https://user-images.githubusercontent.com/56201348/123562134-a4894500-d7a4-11eb-9f33-0643b9ef195b.jpg)
![assessment](https://user-images.githubusercontent.com/56201348/123562137-a81ccc00-d7a4-11eb-9420-9267b8bbde24.jpg)
![fragment score](https://user-images.githubusercontent.com/56201348/123562138-a9e68f80-d7a4-11eb-86ef-69e97e7faf2c.jpg)
