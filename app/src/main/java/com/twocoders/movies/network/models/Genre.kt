package com.twocoders.movies.network.models

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents a genre model for a movie.
 */
data class Genre(
  @JsonProperty("id")
  val id: Int?,
  @JsonProperty("name")
  val name: String?
)
