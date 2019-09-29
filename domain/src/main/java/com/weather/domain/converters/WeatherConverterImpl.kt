package com.weather.domain.converters

import com.weather.core.remote.models.open_weather_models.WeatherResponse
import com.weather.domain.models.CurrentWeather
import kotlin.math.roundToInt

class WeatherConverterImpl:WeatherConverter {

    private val direction = listOf("C","С-В","В","Ю-В","Ю","Ю-З","З","С-З")

    override fun convertFromWeatherResponseToCerrentWeather(weatherResponse: WeatherResponse): CurrentWeather {

        return with(weatherResponse){
            CurrentWeather(
                "${main.temp}°C",
                "${main.temp_max}°C",
                "${main.temp_min}°C",
                "${main.pressure} мбар",
                "${main.humidity}%",
                "${wind.speed} метр/сек",
                direction[(((wind.deg % 360) / 45) % 8).roundToInt()],
                weather[0].description
            )
        }
    }
}