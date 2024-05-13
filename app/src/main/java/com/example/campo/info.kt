package com.example.campo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import retrofit2.Retrofit
import retrofit2.Response
import retrofit2.Call
import retrofit2.Callback
import retrofit2.converter.gson.GsonConverterFactory



class info : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_info, container, false)
        val weatherIconCode = "02d"
        val iconName = "ic_weather_$weatherIconCode"
        val resourceId = resources.getIdentifier(iconName, "drawable", context?.packageName)
        view.findViewById<ImageView>(R.id.weatherIcon).setImageResource(resourceId)
        // Inflate the layout for this fragment
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchRainChance()
    }

    private fun fetchRainChance() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(WeatherService::class.java)
        val call = service.getRainChance("Ameca, MX", "8f7c20b7386faf2fb760e57ebb2a372c")

        call.enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if (response.isSuccessful) {
                    val weatherResponse = response.body()
                    val rainChanceTextView: TextView = view?.findViewById(R.id.rain_chance_text_view) ?: return
                    val temp: TextView = view?.findViewById(R.id.temp) ?: return
                    val humidity: TextView = view?.findViewById(R.id.humedad) ?: return
                    temp.text = "Temperatura: ${weatherResponse?.main?.temp}°C"
                    humidity.text = "Humedad: ${weatherResponse?.main?.humidity}%"
                    rainChanceTextView.text = "Posibilidad de lluvia: ${traducir(weatherResponse?.weather?.firstOrNull()?.description.toString())}"
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
            }
        })
    }
}


val traducciones = mapOf(
    "clear sky" to "Cielo despejado",
    "broken clouds" to "Nubes quebradas",
    "scattered clouds" to "Nubes dispersas",
    "few clouds"  to "Poco nublado",
    "overcast clouds" to "Nublado",
    "shower rain" to "Lluvia moderada",
    "mist" to "Neblina",

)

fun traducir(palabra: String): String {
    return traducciones[palabra] ?: "Palabra no encontrada"
}

