package com.weather.domain.converters

import com.weather.core.remote.helpers.toIntOrNull
import com.weather.core.remote.models.open_weather_models.WeatherResponse
import com.weather.domain.models.CurrentWeather
import kotlin.math.roundToInt

class WeatherConverterImpl:WeatherConverter {

    private val direction = listOf("C","С-В","В","Ю-В","Ю","Ю-З","З","С-З")

    override fun convertFromWeatherResponseToCerrentWeather(weatherResponse: WeatherResponse): CurrentWeather {

        return with(weatherResponse){
            CurrentWeather(
                "${main.temp}°",
                "${main.temp_max.toIntOrNull()?: main.temp_max}",
                "${main.temp_min.toIntOrNull()?: main.temp_min}",
                "${main.pressure} мбар",
                "${main.humidity}%",
                "${wind.speed} метр/сек",
                direction[(((wind.deg % 360) / 45) % 8).roundToInt()],
                weather[0].description.capitalize(),
                name
            )
        }
    }
}