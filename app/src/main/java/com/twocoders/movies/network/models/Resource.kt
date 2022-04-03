package com.twocoders.movies.network.models

/**
 * Data class that encapsulates a [State], a successful outcome with a value of type [T]
 * or an error of type [CustomError].
 */
data class Resource<out T>(
	val state: State,
	val data: T?,
	val error: CustomError? = null
) {

	/**
	 * Possible states for a [Resource]
	 */
	enum class State {
		LOADING,
		SUCCESS,
		ERROR
	}

	companion object {
		fun <T> loading(data: T? = null) = Resource(state = State.LOADING, data = data)
		fun <T> success(data: T? = null) = Resource(state = State.SUCCESS, data = data)
		fun <T> error(error: CustomError? = null, data: T? = null) = Resource(state = State.ERROR, data = data, error = error)
	}
}