package com.example.campo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.converter.gson.GsonConverterFactory



class info : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
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
        val call = service.getRainChance("Guadalajara, MX", "8f7c20b7386faf2fb760e57ebb2a372c")

        call.enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if (response.isSuccessful) {
                    // Aquí actualizas tu UI con la respuesta, por ejemplo, la posibilidad de lluvia.
                    val weatherResponse = response.body()
                    // Suponiendo que tienes un TextView para mostrar la posibilidad de lluvia.
                    val rainChanceTextView: TextView = view?.findViewById(R.id.rain_chance_text_view) ?: return
                    rainChanceTextView.text = "Posibilidad de lluvia: ${weatherResponse?.weather?.firstOrNull()?.description}"
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
            }
        })
    }
}

