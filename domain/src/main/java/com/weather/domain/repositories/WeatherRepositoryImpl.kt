package com.weather.domain.repositories

import com.weather.core.remote.providers.WeatherProvider
import com.weather.domain.converters.WeatherConverter
import com.weather.domain.models.CurrentWeather
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WeatherRepositoryImpl(
    private val weatherProvider:WeatherProvider,
    private val weatherConverter:WeatherConverter
):WeatherRepository {

    override fun fetchCurrentWeather(lat: Double, lon: Double): Single<CurrentWeather> {
        return weatherProvider.fetchCurrentWeather(lat,lon)
            .map { weatherConverter.convertFromWeatherResponseToCerrentWeather(it) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}