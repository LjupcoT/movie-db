package com.twocoders.movies.home.service

import com.twocoders.movies.errorhandling.ErrorCodes
import com.twocoders.movies.errorhandling.exceptions.NoConnectionException
import com.twocoders.movies.network.apis.MoviesDbRestApi
import com.twocoders.movies.network.models.CustomError
import com.twocoders.movies.network.models.MovieDetails
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
      } catch (e: NoConnectionException) {
        logger.severe("Device has no connection. Request failed.")
        Resource.error(CustomError(code = ErrorCodes.NO_CONNECTION_AVAILABLE.value))
      } catch (e: Exception) {
        logger.severe("Retrieving popular movies list: FAILED")
        logger.severe(e.toString())
        Resource.error(CustomError(throwable = e, code = -1))
      }
    }
  }

  override suspend fun getMovieDetails(movieId: Int): Resource<MovieDetails> {
    return withContext(Dispatchers.Default) {
      try {
        val response = api.getMovieDetails(movieId)
        if (response.isSuccessful && response.body() != null) {
          logger.info("Retrieving movie details: SUCCESSFUL")
          Resource.success(response.body())
        } else {
          logger.info("Retrieving movie details: FAILED")
          logger.severe(response.errorBody().toString())
          Resource.error(CustomError(code = response.code()))
        }
      } catch (e: NoConnectionException) {
        logger.severe("Device has no connection. Request failed.")
        Resource.error(CustomError(code = ErrorCodes.NO_CONNECTION_AVAILABLE.value))
      } catch (e: Exception) {
        logger.info("Retrieving movie details: FAILED")
        logger.severe(e.toString())
        Resource.error(CustomError(throwable = e, code = -1))
      }
    }
  }
}