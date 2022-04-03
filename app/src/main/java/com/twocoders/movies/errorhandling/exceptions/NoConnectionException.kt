package com.twocoders.movies.errorhandling.exceptions

import okio.IOException

/**
 * Custom exception for marking that the device has no connection.
 */
class NoConnectionException : IOException() {}