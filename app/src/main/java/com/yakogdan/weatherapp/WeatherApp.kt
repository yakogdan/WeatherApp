package com.yakogdan.weatherapp

import android.app.Application
import com.yakogdan.weatherapp.di.ApplicationComponent
import com.yakogdan.weatherapp.di.DaggerApplicationComponent

class WeatherApp: Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}