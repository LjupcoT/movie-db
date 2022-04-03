package com.twocoders.movies.network.models

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents a model class for a language.
 */
data class LanguageModel(
  @JsonProperty("iso_639_1")
  val languageIso: String?,
  @JsonProperty("name")
  val name: String?,
  @JsonProperty("english_name")
  val english_name: String?
)
