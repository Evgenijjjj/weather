package com.jhapp.mc.dagger.modules

import com.weather.etu.api.weather_api.WeatherApi
import com.weather.etu.interactors.WeatherInteractor
import com.weather.etu.interactors.WeatherInteractorImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorsModule {

    @Provides
    @Singleton
    fun provideLoginInteractor(api: WeatherApi): WeatherInteractor
            = WeatherInteractorImpl(api)
}