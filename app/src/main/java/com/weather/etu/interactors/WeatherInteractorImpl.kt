package com.weather.etu.interactors

import com.weather.etu.api.models.DailyWeather
import com.weather.etu.api.weather_api.WeatherApi
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class WeatherInteractorImpl(
    private val api: WeatherApi
): WeatherInteractor {
    override fun getCurrentWeather(): Single<DailyWeather> {
        return api.getCurrentWeather().subscribeOn(Schedulers.io())
    }
}