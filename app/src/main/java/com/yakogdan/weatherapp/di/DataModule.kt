package com.yakogdan.weatherapp.di

import android.content.Context
import com.yakogdan.weatherapp.data.local.db.FavouriteCitiesDao
import com.yakogdan.weatherapp.data.local.db.FavouriteDatabase
import com.yakogdan.weatherapp.data.network.api.ApiFactory
import com.yakogdan.weatherapp.data.network.api.ApiService
import com.yakogdan.weatherapp.data.repository.FavouriteRepositoryImpl
import com.yakogdan.weatherapp.data.repository.SearchRepositoryImpl
import com.yakogdan.weatherapp.data.repository.WeatherRepositoryImpl
import com.yakogdan.weatherapp.domain.repository.FavouriteRepository
import com.yakogdan.weatherapp.domain.repository.SearchRepository
import com.yakogdan.weatherapp.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @[ApplicationScope Binds]
    fun bindFavouriteRepository(impl: FavouriteRepositoryImpl): FavouriteRepository

    @[ApplicationScope Binds]
    fun bindWeatherRepository(impl: WeatherRepositoryImpl): WeatherRepository

    @[ApplicationScope Binds]
    fun bindSearchRepository(impl: SearchRepositoryImpl): SearchRepository


    companion object {

        @[ApplicationScope Provides]
        fun provideApiService(): ApiService = ApiFactory.apiService

        @[ApplicationScope Provides]
        fun provideFavouriteDatabase(context: Context): FavouriteDatabase =
            FavouriteDatabase.getInstance(context = context)

        @[ApplicationScope Provides]
        fun provideFavouriteCitiesDao(database: FavouriteDatabase): FavouriteCitiesDao =
            database.favouriteCitiesDao()
    }
}