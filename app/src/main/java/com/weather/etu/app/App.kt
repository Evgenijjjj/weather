package com.weather.etu.app

import android.app.Application
import com.jhapp.mc.dagger.modules.AppModule
import com.jhapp.mc.dagger.modules.InteractorsModule
import com.weather.etu.dagger.components.AppComponent
import com.weather.etu.dagger.components.DaggerAppComponent
import com.weather.etu.dagger.modules.ApiModule

class App: Application() {

    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = buildComponent()
        component.inject(this)
    }

    private fun buildComponent(): AppComponent = DaggerAppComponent.builder()
        .appModule(AppModule(applicationContext))
//        .databaseModule(DatabaseModule())
        .apiModule(ApiModule())
        .interactorsModule(InteractorsModule())
        .build()
}