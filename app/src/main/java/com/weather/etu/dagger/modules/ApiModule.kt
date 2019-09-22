package com.weather.etu.dagger.modules

import com.weather.etu.api.ApiBuilder
import com.weather.etu.api.RxMoshiApiBuilder
import com.weather.etu.api.WEATHER_API
import com.weather.etu.api.weather_api.WeatherApi
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ApiModule {

    companion object {
        private const val WEATHER_URL_NAME = "weather_api"
    }

    @Provides
    @Named(WEATHER_URL_NAME)
    fun provideWeatherUrl() = WEATHER_API

    @Provides
    fun provideWeatherApiBuilder(@Named(WEATHER_URL_NAME) url: String): ApiBuilder = RxMoshiApiBuilder(url)

    @Provides
    fun provideWeatherApi(apiBuilder: ApiBuilder): WeatherApi
            = apiBuilder.buildApi(WeatherApi::class.java)
}