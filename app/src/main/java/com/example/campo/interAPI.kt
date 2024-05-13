package com.example.campo

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("data/2.5/weather")
    fun getRainChance(@Query("q") location: String, @Query("appid") apiKey: String, @Query("units") units: String = "metric"): Call<WeatherResponse>
}