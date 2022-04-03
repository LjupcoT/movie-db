package com.twocoders.movies.home.service

import com.twocoders.movies.network.models.MovieDetails
import com.twocoders.movies.network.models.PopularMoviesResponse
import com.twocoders.movies.network.models.Resource

/**
 * Interface for the Movies DB repository
 */
interface MoviesService {

  /**
   * Retrieve a list of popular movies on Movies DB.
   *
   * @param page [Int] optional parameter for pagination. Default value: 1
   * @return [Resource] wrapping successful/failed response from the API.
   */
  suspend fun getPopularMovies(page: Int = 1): Resource<PopularMoviesResponse>

  /**
   * Retrieve the details of the movie.
   *
   * @param movieId [Int] the ID of the movie whose details we want.
   * @return [Resource] wrapping successful/failed response from the API.
   */
  suspend fun getMovieDetails(movieId: Int): Resource<MovieDetails>

}