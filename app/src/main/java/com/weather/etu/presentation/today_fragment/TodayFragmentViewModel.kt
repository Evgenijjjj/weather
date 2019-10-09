package com.weather.etu.presentation.today_fragment

import android.util.Log
import com.weather.core.remote.providers.WeatherProviderImpl
import com.weather.domain.converters.WeatherConverterImpl
import com.weather.domain.repositories.WeatherRepository
import com.weather.domain.repositories.WeatherRepositoryImpl
import com.weather.etu.app.App
import com.weather.etu.base.BaseViewModel
import javax.inject.Inject

class TodayFragmentViewModel: BaseViewModel() {

    @Inject
    lateinit var repository:WeatherRepository

    init {
        App.component.inject(this)
    }

    //Тут ты уже сам MVVM делаешь через livedate
    fun fetchCurrentWeather(){
        repository.fetchCurrentWeather(59.934280,30.335098)
            .subscribe(
                {
                    Log.d("WeatherResponseTest",it.toString())
                },
                {
                    Log.d("WeatherResponseTest",it.toString())
                }
            )
    }
}