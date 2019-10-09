package com.weather.etu.presentation.today_fragment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.weather.domain.models.CurrentWeather
import com.weather.domain.repositories.WeatherRepository
import com.weather.etu.app.App
import com.weather.etu.base.BaseViewModel
import javax.inject.Inject

class TodayFragmentViewModel: BaseViewModel() {

    @Inject
    lateinit var repository: WeatherRepository

    val currentWeatherLiveData = MutableLiveData<CurrentWeather>()

    init {
        App.component.inject(this)
    }

    fun fetchCurrentWeather(){
        disposable.add(
            repository.fetchCurrentWeather(59.934280,30.335098)
                .safeSubscribe(currentWeatherLiveData::postValue)
        )
    }
}