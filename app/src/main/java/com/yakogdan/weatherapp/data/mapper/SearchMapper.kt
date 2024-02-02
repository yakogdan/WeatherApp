package com.yakogdan.weatherapp.data.mapper

import com.yakogdan.weatherapp.data.network.dto.CityDto
import com.yakogdan.weatherapp.domain.entity.City

fun CityDto.toEntity(): City = City(id = id, name = name, country = country)

fun List<CityDto>.toEntities(): List<City> = map { it.toEntity() }