package com.twocoders.movies.network.models

import com.fasterxml.jackson.annotation.JsonValue

/**
 * Enum class representing the possible types of movies status.
 */
enum class MovieStatus(@JsonValue val value: String) {
  RUMORED("Rumored"),
  PLANNED("Planned"),
  IN_PRODUCTION("In Production"),
  POST_PRODUCTION("Post Production"),
  RELEASED("Released"),
  CANCELED("Canceled");
}
