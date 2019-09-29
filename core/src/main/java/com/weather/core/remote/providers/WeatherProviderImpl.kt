package com.weather.core.remote.providers

import android.util.Log
import com.weather.core.remote.helpers.RetrofitFactory
import com.weather.core.remote.models.open_weather_models.WeatherResponse
import io.reactivex.Single

class WeatherProviderImpl:WeatherProvider {

    private val openWeatherService = RetrofitFactory.getOpenWeatherService()

    override fun fetchCurrentWeather(lat: Double, lon: Double): Single<WeatherResponse> {
        Log.d("WeatherResponseTest","$lat $lon")
        return openWeatherService.getCurrentWeather(lat,lon)
    }
}