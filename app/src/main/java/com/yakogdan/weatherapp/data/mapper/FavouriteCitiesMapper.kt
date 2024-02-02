package com.yakogdan.weatherapp.data.mapper

import com.yakogdan.weatherapp.data.local.model.CityDbModel
import com.yakogdan.weatherapp.domain.entity.City

fun City.toDbModel(): CityDbModel = CityDbModel(id = id, name = name, country = country)

fun CityDbModel.toEntity(): City = City(id = id, name = name, country = country)

fun List<CityDbModel>.toEntities(): List<City> = map { it.toEntity() }