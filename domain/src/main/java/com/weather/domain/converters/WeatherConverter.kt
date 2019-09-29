package com.weather.domain.converters

import com.weather.core.remote.models.open_weather_models.WeatherResponse
import com.weather.domain.models.CurrentWeather

interface WeatherConverter {

    fun convertFromWeatherResponseToCerrentWeather(weatherResponse:WeatherResponse):CurrentWeather

}