package com.weather.etu.dagger.modules

import com.weather.core.remote.providers.WeatherProvider
import com.weather.core.remote.providers.WeatherProviderImpl
import dagger.Module
import dagger.Provides


@Module
class ApiModule {

    @Provides
    fun provideWeatherProvider():WeatherProvider = WeatherProviderImpl()
}