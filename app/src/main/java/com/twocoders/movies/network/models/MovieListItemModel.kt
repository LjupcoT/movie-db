package com.twocoders.movies.network.models

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents a movie item in a list of movies.
 */
data class MovieListItemModel(
  @JsonProperty("poster_path")
  val posterPath: String?,
  @JsonProperty("adult")
  val adult: Boolean?,
  @JsonProperty("overview")
  val overview: String?,
  @JsonProperty("release_date")
  val releaseDate: String?,
  @JsonProperty("genre_ids")
  val genreIds: List<Int>?,
  @JsonProperty("id")
  val id: Int?,
  @JsonProperty("original_title")
  val originalTitle: String?,
  @JsonProperty("original_language")
  val originalLanguage: String?,
  @JsonProperty("title")
  val title: String?,
  @JsonProperty("backdrop_path")
  val backdropPath: String?,
  @JsonProperty("popularity")
  val popularity: Double?,
  @JsonProperty("vote_count")
  val voteCount: Int?,
  @JsonProperty("video")
  val video: Boolean?,
  @JsonProperty("vote_average")
  val vote_average: Double?
)
