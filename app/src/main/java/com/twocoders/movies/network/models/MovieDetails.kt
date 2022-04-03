package com.twocoders.movies.network.models

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents a model of the complete details of a movie.
 */
data class MovieDetails(
  @JsonProperty("adult")
  val adult: Boolean?,
  @JsonProperty("backdrop_path")
  val backdropPath: String?,
  @JsonProperty("belongs_to_collection")
  val belongsToCollection: CollectionModel?,
  @JsonProperty("budget")
  val budget: Int?,
  @JsonProperty("genres")
  val genres: List<Genre>?,
  @JsonProperty("homepage")
  val homepage: String?,
  @JsonProperty("id")
  val id: Int?,
  @JsonProperty("imdb_id")
  val imdb_id: String?,
  @JsonProperty("original_language")
  val originalLanguage: String?,
  @JsonProperty("original_title")
  val originalTitle: String?,
  @JsonProperty("overview")
  val overview: String?,
  @JsonProperty("popularity")
  val popularity: Double?,
  @JsonProperty("poster_path")
  val posterPath: String?,
  @JsonProperty("production_companies")
  val productionCompanies: List<ProductionCompany>?,
  @JsonProperty("production_countries")
  val productionCountries: List<ProductionCountry>?,
  @JsonProperty("release_date")
  val releaseDate: String?,
  @JsonProperty("revenue")
  val revenue: Int?,
  @JsonProperty("runtime")
  val runtime: Int?,
  @JsonProperty("spoken_languages")
  val spokenLanguages: List<LanguageModel>?,
  @JsonProperty("status")
  val status: MovieStatus?,
  @JsonProperty("tagline")
  val tagline: String?,
  @JsonProperty("title")
  val title: String?,
  @JsonProperty("video")
  val video: Boolean?,
  @JsonProperty("vote_average")
  val voteAverage: Double?,
  @JsonProperty("vote_count")
  val voteCount: Int?
)