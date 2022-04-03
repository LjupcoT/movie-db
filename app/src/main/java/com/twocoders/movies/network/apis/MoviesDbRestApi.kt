package com.twocoders.movies.network.apis

import com.twocoders.movies.network.models.MovieDetails
import com.twocoders.movies.network.models.PopularMoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * REST API for the Movies DB
 */
interface MoviesDbRestApi {

  @GET("movie/popular?api_key=$API_KEY")
  suspend fun getPopularMovies(
    @Query("page") pageNum: Int
  ): Response<PopularMoviesResponse>

  @GET("movie/{movieId}?api_key=$API_KEY")
  suspend fun getMovieDetails(
    @Path("movieId") movieId: Int
  ): Response<MovieDetails>
}

private const val API_KEY = "ec9cccee9a63a1ed7ca1890b8a0bd6d8"
