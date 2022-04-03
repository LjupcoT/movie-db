package com.twocoders.movies.home.service

import com.twocoders.movies.network.apis.MoviesDbRestApi
import com.twocoders.movies.network.models.CustomError
import com.twocoders.movies.network.models.PopularMoviesResponse
import com.twocoders.movies.network.models.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.logging.Logger

/**
 * Implementation of [MoviesService] using the [MoviesDbRestApi].
 */
class MoviesServiceLogic(private val api: MoviesDbRestApi) : MoviesService {

  private val logger: Logger = Logger.getLogger(MoviesServiceLogic::class.java.simpleName)

  override suspend fun getPopularMovies(page: Int): Resource<PopularMoviesResponse> {
    return withContext(Dispatchers.Default) {
      try {
        val response = api.getPopularMovies(page)
        if (response.isSuccessful && response.body() != null) {
          logger.info("Retrieving popular movies list: SUCCESSFUL")
          Resource.success(response.body())
        } else {
          logger.severe("Retrieving popular movies list: FAILED")
          logger.severe(response.errorBody().toString())
          Resource.error(CustomError(code = response.code()))
        }
      } catch (e: Exception) {
        logger.severe("Retrieving popular movies list: FAILED")
        logger.severe(e.toString())
        Resource.error(CustomError(throwable = e, code = -1))
      }
    }
  }
}