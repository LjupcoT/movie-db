package com.twocoders.movies.network.models

/**
 * Data class that contains information about an error or exception.
 */
data class CustomError(
	val throwable: Throwable? = null,
	val code: Int
)
