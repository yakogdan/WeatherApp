package com.yakogdan.weatherapp.data.repository

import com.yakogdan.weatherapp.data.local.db.FavouriteCitiesDao
import com.yakogdan.weatherapp.data.mapper.toDbModel
import com.yakogdan.weatherapp.data.mapper.toEntities
import com.yakogdan.weatherapp.domain.entity.City
import com.yakogdan.weatherapp.domain.repository.FavouriteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavouriteRepositoryImpl @Inject constructor(
    private val favouriteCitiesDao: FavouriteCitiesDao
) : FavouriteRepository {
    override val favouriteCities: Flow<List<City>> = favouriteCitiesDao.getFavouriteCities()
        .map { it.toEntities() }

    override fun observeIsFavourite(cityId: Int): Flow<Boolean> =
        favouriteCitiesDao.observeIsFavourite(cityId)

    override suspend fun addToFavourite(city: City) =
        favouriteCitiesDao.addToFavourite(city.toDbModel())

    override suspend fun removeFromFavourite(cityId: Int) =
        favouriteCitiesDao.removeToFavourite(cityId)
}