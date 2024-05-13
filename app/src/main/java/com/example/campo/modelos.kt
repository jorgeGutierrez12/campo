package com.example.campo

data class WeatherResponse(
    val main: Main,
    val weather: List<Weather>
)

data class Main(
    var temp: Float = 0.2f,
    val humidity : Int
)

data class Weather(
    val main: String,
    val description: String
)