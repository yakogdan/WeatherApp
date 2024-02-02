package com.yakogdan.weatherapp.data.repository

import com.yakogdan.weatherapp.data.mapper.toEntities
import com.yakogdan.weatherapp.data.network.api.ApiService
import com.yakogdan.weatherapp.domain.entity.City
import com.yakogdan.weatherapp.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : SearchRepository {
    override suspend fun search(query: String): List<City> =
        apiService.searchCity(query).toEntities()
}