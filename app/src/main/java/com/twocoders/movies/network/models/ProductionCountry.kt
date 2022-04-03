package com.twocoders.movies.network.models

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents a production country of a company.
 */
data class ProductionCountry(
  @JsonProperty("iso_3166_1")
  val countryIso: String?,
  @JsonProperty("name")
  val name: String?
)