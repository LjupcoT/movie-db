package com.twocoders.movies.di

import com.twocoders.movies.network.HttpConfiguration
import com.twocoders.movies.network.RestClient
import com.twocoders.movies.network.api.MoviesDbRestApi
import org.koin.dsl.module

/**
 * Koin module that declares dependencies that can be injected anywhere in the app.
 */
val appModule = module {

  single { HttpConfiguration.getHttpBuilder().build() }
  single { RestClient.createService(MoviesDbRestApi::class.java) }

}