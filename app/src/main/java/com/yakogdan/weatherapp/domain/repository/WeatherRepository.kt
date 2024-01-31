package com.yakogdan.weatherapp.domain.repository

import com.yakogdan.weatherapp.domain.entity.Forecast
import com.yakogdan.weatherapp.domain.entity.Weather

interface WeatherRepository {

    suspend fun getWeather(cityId: Int): Weather

    suspend fun getForecast(cityId: Int): Forecast
}