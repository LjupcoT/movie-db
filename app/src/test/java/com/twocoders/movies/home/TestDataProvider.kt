package com.twocoders.movies.home

import com.twocoders.movies.network.models.MovieDetails
import com.twocoders.movies.network.models.MovieListItemModel
import com.twocoders.movies.network.models.MovieStatus
import com.twocoders.movies.network.models.PopularMoviesResponse

val movieListItem1 = MovieListItemModel(
  posterPath = "poster_path",
  adult = false,
  overview = "overview movie 1",
  releaseDate = "2022",
  genreIds = null,
  id = 123,
  originalTitle = null,
  originalLanguage = null,
  title = "Movie List Item 1",
  backdropPath = null,
  popularity = 12.3,
  voteCount = 123,
  vote_average = 3.0,
  video = false
)

val movieListItem2 = MovieListItemModel(
  posterPath = "poster_path",
  adult = true,
  overview = "overview movie 2",
  releaseDate = "2021",
  genreIds = null,
  id = 567,
  originalTitle = null,
  originalLanguage = null,
  title = "Movie List Item 2",
  backdropPath = null,
  popularity = 45.6,
  voteCount = 234,
  vote_average = 3.6,
  video = false
)

val moviesResponseSuccessful = PopularMoviesResponse(
  page = 1,
  results = listOf(movieListItem1, movieListItem2),
  totalResults = 100,
  totalPages = 10,
)

val movieDetails = MovieDetails(
  adult = false,
  backdropPath = null,
  belongsToCollection = null,
  budget = 12345,
  genres = null,
  homepage = null,
  id = 123,
  imdb_id = null,
  originalLanguage = null,
  originalTitle = null,
  overview = "Overview",
  popularity = 23.5,
  posterPath = "poster_path.png",
  productionCompanies = emptyList(),
  productionCountries = emptyList(),
  releaseDate = "2020",
  revenue = 12345,
  runtime = null,
  spokenLanguages = null,
  status = MovieStatus.RELEASED,
  tagline = "",
  title = "Movie Details 1",
  video = false,
  voteAverage = 3.7,
  voteCount = 8328
)