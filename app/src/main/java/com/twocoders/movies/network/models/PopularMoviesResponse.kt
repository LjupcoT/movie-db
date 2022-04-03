package com.twocoders.movies.network.models

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents the response from the popular movies API endpoint.
 */
data class PopularMoviesResponse(
  @JsonProperty("page")
  val page: Int?,
  @JsonProperty("results")
  val results: List<MovieListItemModel>?,
  @JsonProperty("total_results")
  val totalResults: Int?,
  @JsonProperty("total_pages")
  val totalPages: Int?
)
