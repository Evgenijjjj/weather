package com.weather.etu.dagger.modules

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule(val appContext: Context) {
    @Provides
    fun provideContext() = appContext
}