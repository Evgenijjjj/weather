package com.weather.domain.repositories

import android.annotation.SuppressLint
import android.location.Location
import android.location.LocationManager
import android.util.Log
import com.weather.core.remote.providers.WeatherProvider
import com.weather.domain.converters.WeatherConverter
import com.weather.domain.models.CurrentWeather
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class WeatherRepositoryImpl(
    private val weatherProvider: WeatherProvider,
    private val weatherConverter: WeatherConverter,
    private val locationManager: LocationManager
) : WeatherRepository {

    override fun fetchCurrentWeather(lat: Double, lon: Double): Single<CurrentWeather> {
        return weatherProvider.fetchCurrentWeather(lat, lon)
            .map { weatherConverter.convertFromWeatherResponseToCerrentWeather(it) }
            .subscribeOn(Schedulers.io())
    }

    @SuppressLint("MissingPermission")
    override fun fetchCurrentWeather(): Single<CurrentWeather> {
        return Single.merge(
            Single.just(locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)),
            Single.just(locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER))
            )
            .firstOrError()
            .flatMap { fetchCurrentWeather(it.latitude, it.longitude) }
            .subscribeOn(Schedulers.io())


    }
}