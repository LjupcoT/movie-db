package com.twocoders.movies.network.models

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents a model class for a collection to which a movie belongs to.
 */
data class CollectionModel(
  @JsonProperty("id")
  val id: Int?,
  @JsonProperty("name")
  val name: String?,
  @JsonProperty("poster_path")
  val posterPath: String?,
  @JsonProperty("backdrop_path")
  val backdropPath: String?
)