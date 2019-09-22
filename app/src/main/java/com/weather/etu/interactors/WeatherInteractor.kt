package com.weather.etu.interactors

import com.weather.etu.api.models.DailyWeather
import io.reactivex.Single

interface WeatherInteractor {
    fun getCurrentWeather(): Single<DailyWeather>
}