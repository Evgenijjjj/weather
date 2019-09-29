package com.weather.domain.models

data class CurrentWeather(
    val temp:String,// в градусах цельсия
    val tempMax:String,
    val tempMin:String,
    val pressure:String,// атмосферное давление мбар
    val humidity: String,// влажность в процентах
    val speedWind:String,// метр/сек
    val directionWind:String,// Ю-В, В-З, ....
    val description:String // ясно, .....
)