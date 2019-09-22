package com.weather.etu.api.weather_api

import com.weather.etu.api.CONTENT_TYPE
import com.weather.etu.api.models.DailyWeather
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface WeatherApi {

    @Headers(CONTENT_TYPE)
    @GET("/currentWeather")
    fun getCurrentWeather(): Single<DailyWeather>
}