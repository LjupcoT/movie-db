package com.twocoders.movies.network.models

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents a model class for a production company of a movie.
 */
data class ProductionCompany(
  @JsonProperty("name")
  val name: String?,
  @JsonProperty("id")
  val id: Int?,
  @JsonProperty("logo_path")
  val logoPath: String?,
  @JsonProperty("origin_country")
  val originCountry: String?
)
