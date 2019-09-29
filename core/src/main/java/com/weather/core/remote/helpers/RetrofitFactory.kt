package com.weather.core.remote.helpers

import com.weather.core.remote.helpers.Constants.Companion.BASE_URL_OPEN_WEATHER
import com.weather.core.remote.services.OpenWeatherService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitFactory {

    companion object{

        private fun getOkHttpInstance(): OkHttpClient {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BASIC

            return OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build()
        }

        private fun getRetrofitInstance(baseUrl:String): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(getOkHttpInstance())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun getOpenWeatherService() = getRetrofitInstance(BASE_URL_OPEN_WEATHER).create(OpenWeatherService::class.java)
    }

}