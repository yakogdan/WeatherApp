package com.yakogdan.weatherapp.domain.repository

import com.yakogdan.weatherapp.domain.entity.City

interface SearchRepository {

    suspend fun search(query: String): List<City>
}